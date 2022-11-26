package com.munini.adibas.model;

public class ItemCategory {
    private String title;
    private int items;
    private int coverImageDrawableId;
    private int showCaseImage1DrawableId;
    private int showCaseImage2DrawableId;
    private int showCaseImage3DrawableId;

    public ItemCategory(String title, int items, int coverImageDrawableId, int showCaseImage1DrawableId, int showCaseImage2DrawableId, int showCaseImage3DrawableId) {
        this.title = title;
        this.items = items;
        this.coverImageDrawableId = coverImageDrawableId;
        this.showCaseImage1DrawableId = showCaseImage1DrawableId;
        this.showCaseImage2DrawableId = showCaseImage2DrawableId;
        this.showCaseImage3DrawableId = showCaseImage3DrawableId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getItems() {
        return items;
    }

    public void setItems(int items) {
        this.items = items;
    }

    public int getCoverImageDrawableId() {
        return coverImageDrawableId;
    }

    public void setCoverImageDrawableId(int coverImageDrawableId) {
        this.coverImageDrawableId = coverImageDrawableId;
    }

    public int getShowCaseImage1DrawableId() {
        return showCaseImage1DrawableId;
    }

    public void setShowCaseImage1DrawableId(int showCaseImage1DrawableId) {
        this.showCaseImage1DrawableId = showCaseImage1DrawableId;
    }

    public int getShowCaseImage2DrawableId() {
        return showCaseImage2DrawableId;
    }

    public void setShowCaseImage2DrawableId(int showCaseImage2DrawableId) {
        this.showCaseImage2DrawableId = showCaseImage2DrawableId;
    }

    public int getShowCaseImage3DrawableId() {
        return showCaseImage3DrawableId;
    }

    public void setShowCaseImage3DrawableId(int showCaseImage3DrawableId) {
        this.showCaseImage3DrawableId = showCaseImage3DrawableId;
    }

    @Override
    public String toString() {
        return "ItemCategory{" +
                "title='" + title + '\'' +
                ", items=" + items +
                ", coverImageDrawableId=" + coverImageDrawableId +
                ", showCaseImage1DrawableId=" + showCaseImage1DrawableId +
                ", showCaseImage2DrawableId=" + showCaseImage2DrawableId +
                ", showCaseImage3DrawableId=" + showCaseImage3DrawableId +
                '}';
    }
}
