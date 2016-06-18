package com.kaishengit.entity;

import com.kaishengit.dao.MovieDao;

import java.util.List;

/**
 * Created by Administrator on 2016/6/18.
 */
public class Page<T> {

    private Integer totalSizes;
    private Integer size;
    private Integer pageNo;
    private Integer totalPageNo;
    private Integer start;
    private List<T> items;

    public List<T> getItems() {
        return items;
    }

    public Page(Integer size, Integer pageNo, Integer totalSizes) {

        this.size = size;
        this.pageNo = pageNo;
        this.totalSizes = totalSizes;

        totalPageNo = totalSizes / size;

        if (totalSizes % size != 0) {
            totalPageNo++;
        }

        if (pageNo > totalPageNo) {
            this.pageNo = totalPageNo;
        }

        if (pageNo <= 0) {
            this.pageNo = 1;
        }
        this.start = (this.pageNo - 1) * this.size;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public Integer getStart() {
        return start;
    }

    public Integer getTotalSizes() {
        return totalSizes;
    }

    public Integer getSize() {
        return size;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public Integer getTotalPageNo() {
        return totalPageNo;
    }
}
