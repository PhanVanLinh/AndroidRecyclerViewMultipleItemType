package vn.linh.androidrecyclerviewmultipleitemtype.base;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class BaseViewHolder<T> extends RecyclerView.ViewHolder {
    private T item;

    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public void bind(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }
}
