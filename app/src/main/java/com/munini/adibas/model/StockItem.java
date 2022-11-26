package com.munini.adibas.model;

public class StockItem {
    private String title;
    private String categoryName;
    private int coverImageDrawableId;

    public StockItem(int coverImageDrawableId,String title, String categoryName) {
        this.title = title;
        this.categoryName = categoryName;
        this.coverImageDrawableId = coverImageDrawableId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCoverImageDrawableId() {
        return coverImageDrawableId;
    }

    public void setCoverImageDrawableId(int coverImageDrawableId) {
        this.coverImageDrawableId = coverImageDrawableId;
    }
}
