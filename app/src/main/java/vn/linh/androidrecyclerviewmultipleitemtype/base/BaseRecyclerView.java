package vn.linh.androidrecyclerviewmultipleitemtype.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import java.util.List;

public class BaseRecyclerView {

    public interface BaseModel {
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
        private List<Class> allModels;
        protected LayoutInflater layoutInflater;

        protected BaseListAdapter(Context context,
                @NonNull DiffUtil.ItemCallback<BaseModel> diffCallback) {
            super(diffCallback);

            layoutInflater = LayoutInflater.from(context);
            allModels = getAllModels();
        }

        public abstract List<Class> getAllModels();

        @Override
        public int getItemViewType(int position) {
            int type = indexOfModel(getItem(position).getClass());
            if (type == -1) {
                throw new RuntimeException(
                        "Missing " + getItem(position).getClass().getSimpleName() + " in models");
            }
            return type;
        }

        protected int indexOfModel(Class model) {
            return allModels.indexOf(model);
        }

        @Override
        public void onBindViewHolder(@NonNull BaseViewHolder baseViewHolder, int position) {
            baseViewHolder.bind(getItem(position));
        }
    }
}
