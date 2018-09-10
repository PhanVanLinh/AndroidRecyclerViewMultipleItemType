package vn.linh.androidrecyclerviewmultipleitemtype.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BaseRecyclerView {

    public interface BaseModel {
        int getType();
    }

    public static abstract class BaseViewHolder<IT extends BaseModel>
            extends RecyclerView.ViewHolder {
        private IT item;

        public BaseViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bind(IT item) {
            this.item = item;
        }

        public IT getItem() {
            return item;
        }
    }

    public static abstract class BaseListAdapter extends ListAdapter<BaseModel, BaseViewHolder> {

        protected LayoutInflater layoutInflater;

        protected BaseListAdapter(Context context,
                @NonNull DiffUtil.ItemCallback<BaseModel> diffCallback) {
            super(diffCallback);
            layoutInflater = LayoutInflater.from(context);
        }

        @Override
        public int getItemViewType(int position) {
            return getItem(position).getType();
        }

        @Override
        public void onBindViewHolder(@NonNull BaseViewHolder baseViewHolder, int position) {
            baseViewHolder.bind(getItem(position));
        }
    }
}
