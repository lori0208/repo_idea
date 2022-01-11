package com.zxz.domain;

/**
 * @ClassName PromotionAdVo
 * @Description TODO
 * @Creat 2022-01-04  22:51:07
 */
public class PromotionAdVo {

    private Integer currentPage;
    private Integer pageSize;

    @Override
    public String toString() {
        return "PromotionAdVo{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                '}';
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
