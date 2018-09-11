package vn.linh.androidrecyclerviewmultipleitemtype.base;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.util.DiffUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

public abstract class BaseAdapter extends ListAdapter<RecyclerViewItem, BaseViewHolder> {
    private List<Class<? extends RecyclerViewItem>> itemClassTypes;

    protected BaseAdapter(@NonNull DiffUtil.ItemCallback<RecyclerViewItem> diffCallback) {
        super(diffCallback);
        itemClassTypes = getAllItemClassTypes();
    }

    @NonNull
    @Override
    public final BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Class<?> modelType = itemClassTypes.get(viewType);
        return onCreateViewHolder(parent, modelType);
    }

    public abstract BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
            Class<?> modelType);

    @SuppressWarnings("unchecked")
    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder baseViewHolder, int position) {
        baseViewHolder.bind(getItem(position));
    }

    @Override
    public final int getItemViewType(int position) {
        RecyclerViewItem item = getItem(position);
        if (itemClassTypes == null) {
            throw new RuntimeException("getAllItemClassTypes() must not return null");
        }
        if (!itemClassTypes.contains(item.getClass())) {
            throw new RuntimeException(
                    "Missing " + item.getClass().getSimpleName() + " in getAllItemClassTypes()");
        }
        return itemClassTypes.indexOf(item.getClass());
    }

    protected abstract List<Class<? extends RecyclerViewItem>> getAllItemClassTypes();

    protected View inflateView(@LayoutRes int layoutRes, ViewGroup parent) {
        return LayoutInflater.from(parent.getContext()).inflate(layoutRes, parent, false);
    }
}