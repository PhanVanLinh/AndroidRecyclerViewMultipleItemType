package vn.linh.androidrecyclerviewmultipleitemtype.screen.main.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.view.View;
import android.view.ViewGroup;
import vn.linh.androidrecyclerviewmultipleitemtype.R;
import vn.linh.androidrecyclerviewmultipleitemtype.base.BaseRecyclerView;
import vn.linh.androidrecyclerviewmultipleitemtype.screen.main.adapter.model.HeaderItem;
import vn.linh.androidrecyclerviewmultipleitemtype.screen.main.adapter.model.PhotoItemType;
import vn.linh.androidrecyclerviewmultipleitemtype.screen.main.adapter.model.ProgressItem;

public class PhotoAdapter extends BaseRecyclerView.BaseListAdapter {

    protected PhotoAdapter(Context context,
            @NonNull DiffUtil.ItemCallback<BaseRecyclerView.BaseModel> diffCallback) {
        super(context, diffCallback);
    }

    @NonNull
    @Override
    public BaseRecyclerView.BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
            int viewType) {
        if (viewType == PhotoItemType.HEADER) {
            View view = layoutInflater.inflate(R.layout.item_header, parent, false);
            return new HeaderViewHolder(view);
        }
        if (viewType == PhotoItemType.PHOTO) {
            View view = layoutInflater.inflate(R.layout.item_photo, parent, false);
            return new ItemViewHolder(view);
        }
        if (viewType == PhotoItemType.SECTION) {
            View view = layoutInflater.inflate(R.layout.item_photo, parent, false);
            return new ItemViewHolder(view);
        }
        if (viewType == PhotoItemType.PROGRESS) {
            View view = layoutInflater.inflate(R.layout.item_photo, parent, false);
            return new ItemViewHolder(view);
        }
        return null;
    }

    class HeaderViewHolder extends BaseRecyclerView.BaseViewHolder<HeaderItem> {

        public HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    class ItemViewHolder extends BaseRecyclerView.BaseViewHolder<ProgressItem> {

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}