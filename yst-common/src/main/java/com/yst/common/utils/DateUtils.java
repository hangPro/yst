package com.yst.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/2/15.
 */
public class DateUtils {

    public static String FORMAT_YYYYMMDD = "YYYY-MM-dd";
    public static String FORMAT_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    public static String formatNowDate(String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date now = new Date();
        return sdf.format(now);
    }

    public static String formatMilliseconds(long millis) {
        StringBuilder sb = new StringBuilder();
        if(millis < 1000L) {
            sb.append(millis).append("毫秒");
        } else if(millis < 60000L) {
            sb.append((int)(millis / 1000L)).append("秒");
            if(millis % 1000L != 0L) {
                sb.append(formatMilliseconds(millis % 1000L));
            }
        } else if(millis < 3600000L) {
            sb.append((int)(millis / 60000L)).append("分");
            if(millis % 60000L != 0L) {
                sb.append(formatMilliseconds(millis % 60000L));
            }
        } else if(millis < 86400000L) {
            sb.append((int)(millis / 3600000L)).append("小时");
            if(millis % 3600000L != 0L) {
                sb.append(formatMilliseconds(millis % 3600000L));
            }
        } else if(millis < 604800000L) {
            sb.append((int)(millis / 86400000L)).append("天");
            if(millis % 86400000L != 0L) {
                sb.append(formatMilliseconds(millis % 86400000L));
            }
        } else if(millis < 2592000000L) {
            sb.append((int)(millis / 604800000L)).append("周");
            if(millis % 604800000L != 0L) {
                sb.append(formatMilliseconds(millis % 604800000L));
            }
        } else {
            sb.append((int)(millis / 2592000000L)).append("月");
            if(millis % 2592000000L != 0L) {
                sb.append(formatMilliseconds(millis % 2592000000L));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(DateUtils.formatNowDate(DateUtils.FORMAT_YYYYMMDD));
    }
}
