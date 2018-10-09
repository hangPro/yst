package com.yst.common.constats;

import com.yst.common.utils.PropertieUtils;

/**
 * 全局常量
 * Created by wangpeng on 2016/12/13.
 */
public class GlobConts {

    public static final String DEFAULT_FORMATTER_YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";


    public static final String DEFAULT_FORMATTER_YYYY_MM_DD = "yyyy-MM-dd";

    public static final String DEFUAL_CHARSET = "UTF-8";

    /**
     * 默认分页大小
     */
    public static final int DEFUALT_PAGE_SIZE = 10;


    public static final Long MAX_EXPIRE_TIME = Long.valueOf(Long.parseLong(String.valueOf(2147483647)) * 1000L);


    /**
     * cookie前缀
     */
    public static final String COOKIE_PREFIX = "Bearer ";


    public static final String SESSION_COOKIE_KEY = "Authorization";


    /**
     * 当前登陆session
     */
    public static final String CURRENT_SESSION_KEY = "current_session";

    public static final String CURRENT_TOKEN_KEY = "current_token";


    /**
     * 图片跟路径
     */
    public static final String IMAGE_ROOT_URL = PropertieUtils.getString("imageRootUrl");


    public static final String IMAGE_LIST_COLUMN = "imgList";


    /**
     * 替换图片字段开头、结尾
     */
    public static final String[] PREFIX = {"imageurl","imageUrl","imgUrl","imgurl"};

    /**
     * 不需要登录的URL
     */
    public static final String[] EXCLUDER_URLS = {"/user/loginUser","/boot/queryValid","/dimNew/getSexEnum","/dimNew/getBigClassEnum"};

    /**
     * 静态下拉框取值
     */
    public static final String dimList = "{ " +
            "\"DIMFLAG1\":[{\"id\":\"17\",\"attribname\":\"长袖\" }," +
            "{\"id\":\"177\",\"attribname\":\"中袖\" }," +
            "{\"id\":\"178\",\"attribname\":\"短袖\" }," +
            "{\"id\":\"180\",\"attribname\":\"三角袖\" }," +
            "{\"id\":\"181\",\"attribname\":\"月亮袖\" }," +
            "{\"id\":\"179\",\"attribname\":\"蝴蝶袖\" }," +
            "{\"id\":\"185\",\"attribname\":\"其他\" }]," +
            "\"DIMFLAG2\":[{\"id\":\"0\",\"attribname\":\"无\" }," +
            "{\"id\":\"182\",\"attribname\":\"灯笼袖\" }," +
            "{\"id\":\"183\",\"attribname\":\"喇叭袖\" }," +
            "{\"id\":\"312\",\"attribname\":\"直筒袖\" }," +
            "{\"id\":\"313\",\"attribname\":\"直筒灯笼袖\" }," +
            "{\"id\":\"314\",\"attribname\":\"喇叭灯笼袖\" }," +
            "{\"id\":\"-1\",\"attribname\":\"其他\" }]," +
            "\"DIMFLAG3\":[{\"id\":\"0\",\"attribname\":\"无\" }," +
            "{\"id\":\"184\",\"attribname\":\"泡泡袖\" }," +
            "{\"id\":\"315\",\"attribname\":\"踩橡筋公主袖\" }," +
            "{\"id\":\"-2\",\"attribname\":\"其他\" }]," +
            "\"DIMFLAG4\":[{\"id\":\"单层\",\"attribname\":\"单层\" }," +
            "{\"id\":\"双层\",\"attribname\":\"双层\" }," +
            "{\"id\":\"0\",\"attribname\":\"无\" }," +
            "{\"id\":\"-1\",\"attribname\":\"其他\" }]," +
            "\"DIMFLAG5\":[{\"id\":\"领边\",\"attribname\":\"领边\" }," +
            "{\"id\":\"领型\",\"attribname\":\"领型\" }," +
            "{\"id\":\"完全\",\"attribname\":\"完全\" }]," +
            "\"DIMFLAG6\":[{\"id\":\"开领\",\"attribname\":\"开领\" }," +
            "{\"id\":\"不开领\",\"attribname\":\"不开领\" }]," +
            "\"DIMFLAG7\":[{\"id\":\"上肩\",\"attribname\":\"上肩\" }," +
            "{\"id\":\"连肩\",\"attribname\":\"连肩\" }]," +
            "\"DIMFLAG8\":[{\"id\":\"扣子\",\"attribname\":\"扣子\" }," +
            "{\"id\":\"拉链\",\"attribname\":\"拉链\" }," +
            "{\"id\":\"无扣\",\"attribname\":\"无扣\" }]}";
}
