package vn.linh.androidrecyclerviewmultipleitemtype.screen.main.adapter;

import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import vn.linh.androidrecyclerviewmultipleitemtype.R;
import vn.linh.androidrecyclerviewmultipleitemtype.base.BaseAdapter;
import vn.linh.androidrecyclerviewmultipleitemtype.base.BaseViewHolder;
import vn.linh.androidrecyclerviewmultipleitemtype.base.RecyclerViewItem;
import vn.linh.androidrecyclerviewmultipleitemtype.screen.main.adapter.model.SectionItem;
import vn.linh.androidrecyclerviewmultipleitemtype.screen.main.adapter.model.PhotoItem;

public class PhotoAdapterMultiple extends BaseAdapter {

    public PhotoAdapterMultiple() {
        super(DIFF_CALLBACK);
    }

    @Override
    protected List<Class<? extends RecyclerViewItem>> getAllItemClassTypes() {
        return new ArrayList<Class<? extends RecyclerViewItem>>() {{
            add(SectionItem.class);
            add(PhotoItem.class);
        }};
    }

    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, Class<?> modelType) {
        if (modelType == SectionItem.class) {
            return new HeaderViewHolder(inflateView(R.layout.item_header, parent));
        }
        if (modelType == PhotoItem.class) {
            return new PhotoItemViewHolder(inflateView(R.layout.item_photo, parent));
        }
        return null;
    }

    static class HeaderViewHolder extends BaseViewHolder<SectionItem> {
        TextView tvTitle;

        HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.text_title);
        }

        @Override
        public void bind(SectionItem item) {
            super.bind(item);
            tvTitle.setText(item.getTitle());
        }
    }

    static class PhotoItemViewHolder extends BaseViewHolder<PhotoItem> {
        TextView tvDescription;

        PhotoItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDescription = itemView.findViewById(R.id.text_description);
        }

        @Override
        public void bind(PhotoItem item) {
            super.bind(item);
            tvDescription.setText(item.getDescription());
        }
    }

    private static final DiffUtil.ItemCallback<RecyclerViewItem> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<RecyclerViewItem>() {
                @Override
                public boolean areItemsTheSame(@NonNull RecyclerViewItem oldUser,
                        @NonNull RecyclerViewItem newUser) {
                    return true;
                }

                @Override
                public boolean areContentsTheSame(@NonNull RecyclerViewItem oldUser,
                        @NonNull RecyclerViewItem newUser) {
                    return oldUser.equals(newUser);
                }
            };
}