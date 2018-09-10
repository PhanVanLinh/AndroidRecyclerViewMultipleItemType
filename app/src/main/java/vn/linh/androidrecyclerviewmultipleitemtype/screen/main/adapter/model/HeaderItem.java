package vn.linh.androidrecyclerviewmultipleitemtype.screen.main.adapter.model;

import vn.linh.androidrecyclerviewmultipleitemtype.base.BaseRecyclerView;

public class HeaderItem implements BaseRecyclerView.BaseModel {

    public int getType() {
        return PhotoItemType.HEADER;
    }
}
