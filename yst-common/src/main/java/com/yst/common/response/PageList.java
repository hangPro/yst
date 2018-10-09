package com.yst.common.response;

import com.yst.common.constats.GlobConts;

import java.util.List;
import java.util.Map;

/**
 * Created by wangpeng on 2016/12/13.
 */
public class PageList<T> {

    private List<T> items;

    private Integer total;

    private Integer pageNo = 1;

    private Map<Object,Object> totalMap;


    /**
     * 每页显示多少条
     */
    private Integer pageSize = GlobConts.DEFUALT_PAGE_SIZE;

    /**
     * 总页数
     */
    private Integer totalPageNum;

    public PageList(List<T> items, Integer total, Integer pageNo, Integer pageSize,Map<Object,Object> totalMap) {
        this.items = items;
        this.total = total;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalPageNum = total%pageSize == 0 ? (total/pageSize) : (total/pageSize+1);
        this.totalMap = totalMap;
    }

    public PageList(List<T> items, Integer total, Integer pageNo, Integer pageSize) {
        this.items = items;
        this.total = total;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalPageNum = total%pageSize == 0 ? (total/pageSize) : (total/pageSize+1);
    }

    public PageList(List<T> items, Integer total, Integer pageNo, Integer pageSize, Integer totalPageNum) {
        this.items = items;
        this.total = total;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalPageNum = totalPageNum;
    }

    public PageList(List<T> items, Integer total) {
        this.items = items;
        this.total = total;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPageNum() {
        return totalPageNum;
    }

    public void setTotalPageNum(Integer totalPageNum) {
        this.totalPageNum = totalPageNum;
    }

    public Map<Object, Object> getTotalMap() {
        return totalMap;
    }

    public void setTotalMap(Map<Object, Object> totalMap) {
        this.totalMap = totalMap;
    }
}
