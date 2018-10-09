package com.yst.common.response;

import java.util.List;

/**
 * Created by wangpeng on 2016/12/13.
 */
public class ImagePageList extends PageList{

    private String bigImageUrl;

    private List<String> groupNoList;

    private List<String> ghList;

    public ImagePageList(List items, Integer total, Integer pageNo, Integer pageSize) {
        super(items, total, pageNo, pageSize);
    }

    public ImagePageList(List items, Integer total, Integer pageNo, Integer pageSize, Integer totalPageNum) {
        super(items, total, pageNo, pageSize, totalPageNum);
    }

    public ImagePageList(List items, Integer total) {
        super(items, total);
    }

    public String getBigImageUrl() {
        return bigImageUrl;
    }

    public void setBigImageUrl(String bigImageUrl) {
        this.bigImageUrl = bigImageUrl;
    }

    public List<String> getGroupNoList() {
        return groupNoList;
    }

    public void setGroupNoList(List<String> groupNoList) {
        this.groupNoList = groupNoList;
    }

    public List<String> getGhList() {
        return ghList;
    }

    public void setGhList(List<String> ghList) {
        this.ghList = ghList;
    }
}
