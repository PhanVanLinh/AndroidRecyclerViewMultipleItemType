package vn.linh.androidrecyclerviewmultipleitemtype.screen.main.adapter;

import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import vn.linh.androidrecyclerviewmultipleitemtype.R;
import vn.linh.androidrecyclerviewmultipleitemtype.base.BaseListAdapter;
import vn.linh.androidrecyclerviewmultipleitemtype.base.BaseViewHolder;
import vn.linh.androidrecyclerviewmultipleitemtype.base.RecyclerViewItem;
import vn.linh.androidrecyclerviewmultipleitemtype.screen.main.adapter.model.HeaderItem;
import vn.linh.androidrecyclerviewmultipleitemtype.screen.main.adapter.model.PhotoItem;
import vn.linh.androidrecyclerviewmultipleitemtype.screen.main.adapter.model.ProgressItem;

public class PhotoAdapter extends BaseListAdapter {

    protected PhotoAdapter(@NonNull DiffUtil.ItemCallback<RecyclerViewItem> diffCallback) {
        super(diffCallback);
    }

    @Override
    protected List<Class<? extends RecyclerViewItem>> getAllModelTypes() {
        return new ArrayList<Class<? extends RecyclerViewItem>>() {{
            add(HeaderItem.class);
            add(PhotoItem.class);
        }};
    }

    @Override
    public BaseViewHolder<? extends RecyclerViewItem> onCreateViewHolder(@NonNull ViewGroup parent,
            Class<?> modelType) {
        if (modelType == HeaderItem.class) {
            return new HeaderViewHolder(inflateView(R.layout.item_header, parent));
        }
        if (modelType == PhotoItem.class) {
            return new ItemViewHolder(inflateView(R.layout.item_photo, parent));
        }
        return null;
    }

    class HeaderViewHolder extends BaseViewHolder<HeaderItem> {

        HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        public void bind(HeaderItem item) {
            super.bind(item);
        }
    }

    class ItemViewHolder extends BaseViewHolder<ProgressItem> {

        ItemViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        public void bind(ProgressItem item) {
            super.bind(item);
        }
    }
}