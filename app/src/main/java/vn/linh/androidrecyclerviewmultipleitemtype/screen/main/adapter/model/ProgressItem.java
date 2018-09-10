package vn.linh.androidrecyclerviewmultipleitemtype.screen.main.adapter.model;

import vn.linh.androidrecyclerviewmultipleitemtype.base.BaseRecyclerView;

public class ProgressItem implements BaseRecyclerView.BaseModel {
    @Override
    public int getType() {
        return PhotoItemType.PROGRESS;
    }
}

