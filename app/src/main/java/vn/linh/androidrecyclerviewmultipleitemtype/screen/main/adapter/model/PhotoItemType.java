package vn.linh.androidrecyclerviewmultipleitemtype.screen.main.adapter.model;

import android.support.annotation.IntDef;
import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;

@Retention(SOURCE)
@IntDef({ PhotoItemType.HEADER, PhotoItemType.SECTION, PhotoItemType.PHOTO })
public @interface PhotoItemType {
    int HEADER = 0;
    int SECTION = 1;
    int PHOTO = 2;
    int PROGRESS = 3;
}
