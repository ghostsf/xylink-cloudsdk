package com.ananwulian.xylinkcloudsdk.model;

import java.util.List;

/*
 * @author xinzhixuan
 * @date 2018-12-05
 * @version V1.0.0
 *
 */
public class PageableNemoDto {
    private int totalPage;
    private int totalRow;
    private int currentPage;
    private int pageSize;
    private List<NemoDto> data;

    public PageableNemoDto() {
    }

    public PageableNemoDto(int currentPage, int pageSize) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(int totalRow) {
        this.totalRow = totalRow;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<NemoDto> getData() {
        return data;
    }

    public void setData(List<NemoDto> data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "PageableNemoDto{" +
                "totalPage=" + totalPage +
                ", totalRow=" + totalRow +
                ", currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", data=" + data +
                '}';
    }
}
