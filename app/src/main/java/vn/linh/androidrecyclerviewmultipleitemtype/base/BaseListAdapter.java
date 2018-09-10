package vn.linh.androidrecyclerviewmultipleitemtype.base;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.util.DiffUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

public abstract class BaseListAdapter<T>
        extends ListAdapter<T, BaseViewHolder<? extends RecyclerViewItem>> {
    private List<Class<? extends RecyclerViewItem>> models;

    protected BaseListAdapter(@NonNull DiffUtil.ItemCallback<T> diffCallback) {
        super(diffCallback);
        models = getAllModelTypes();
    }

    protected View inflateView(@LayoutRes int layoutRes, ViewGroup parent) {
        return LayoutInflater.from(parent.getContext()).inflate(layoutRes, parent, false);
    }

    protected abstract List<Class<? extends RecyclerViewItem>> getAllModelTypes();

    @NonNull
    @Override
    public final BaseViewHolder<? extends RecyclerViewItem> onCreateViewHolder(
            @NonNull ViewGroup parent, int viewType) {
        Class<?> modelType = models.get(viewType);
        return onCreateViewHolder(parent, modelType);
    }

    public abstract BaseViewHolder<? extends RecyclerViewItem> onCreateViewHolder(
            @NonNull ViewGroup parent, Class<?> modelType);

    @Override
    public final int getItemViewType(int position) {
        if (models == null) {
            return 0;
        }
        if (!models.contains(getItem(position).getClass())) {
            throw new RuntimeException("missing model");
        }
        return models.indexOf(getItem(position).getClass());
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder<? extends RecyclerViewItem> baseViewHolder,
            int i) {
        baseViewHolder
    }
}