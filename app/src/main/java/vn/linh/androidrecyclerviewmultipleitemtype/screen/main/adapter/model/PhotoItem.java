package vn.linh.androidrecyclerviewmultipleitemtype.screen.main.adapter.model;

import vn.linh.androidrecyclerviewmultipleitemtype.base.RecyclerViewItem;

public class PhotoItem implements RecyclerViewItem {
    private String title;
    private String message;

    public PhotoItem(String title, String message) {
        this.title = title;
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}