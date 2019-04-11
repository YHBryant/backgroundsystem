package com.yh.tools;

public class SplitePageBean {
    int currentPage=1;//当前第几页
    int pageCount;//一共多少页
    int pageSize=3;//一页多少行数据
    int start;//从第几行开始
    int dataCount;//总共的行数据

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStart() {
        this.start=(currentPage-1)*pageSize;
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getDataCount() {
        return dataCount;
    }

    public void setDataCount(int dataCount) {
        this.dataCount = dataCount;
    }

    @Override
    public String toString() {
        return "SplitePageBean{" +
                "currentPage=" + currentPage +
                ", pageCount=" + pageCount +
                ", pageSize=" + pageSize +
                ", start=" + start +
                ", dataCount=" + dataCount +
                '}';
    }
}
