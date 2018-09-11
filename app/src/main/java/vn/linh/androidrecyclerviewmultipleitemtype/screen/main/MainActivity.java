package vn.linh.androidrecyclerviewmultipleitemtype.screen.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import vn.linh.androidrecyclerviewmultipleitemtype.R;
import vn.linh.androidrecyclerviewmultipleitemtype.base.RecyclerViewItem;
import vn.linh.androidrecyclerviewmultipleitemtype.screen.main.adapter.PhotoAdapterMultiple;
import vn.linh.androidrecyclerviewmultipleitemtype.screen.main.adapter.model.PhotoItem;
import vn.linh.androidrecyclerviewmultipleitemtype.screen.main.adapter.model.SectionItem;

public class MainActivity extends AppCompatActivity {
    private PhotoAdapterMultiple photoAdapter;
    private RecyclerView recyclerViewPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        photoAdapter = new PhotoAdapterMultiple();
        recyclerViewPhoto = findViewById(R.id.recycler_view_photo);
        recyclerViewPhoto.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewPhoto.setAdapter(photoAdapter);
        recyclerViewPhoto.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        ArrayList<RecyclerViewItem> data = new ArrayList<>();
        data.add(new SectionItem("Section 1"));
        data.add(new PhotoItem(R.drawable.ic_launcher_background, "image 1"));
        data.add(new PhotoItem(R.drawable.ic_launcher_background, "image 2"));
        data.add(new PhotoItem(R.drawable.ic_launcher_background, "image 2"));
        data.add(new PhotoItem(R.drawable.ic_launcher_background, "image 2"));
        data.add(new PhotoItem(R.drawable.ic_launcher_background, "image 2"));
        data.add(new PhotoItem(R.drawable.ic_launcher_background, "image 2"));
        data.add(new PhotoItem(R.drawable.ic_launcher_background, "image 2"));
        data.add(new SectionItem("Section 1"));
        data.add(new PhotoItem(R.drawable.ic_launcher_background, "image 2"));
        data.add(new PhotoItem(R.drawable.ic_launcher_background, "image 2"));
        data.add(new PhotoItem(R.drawable.ic_launcher_background, "image 2"));
        data.add(new PhotoItem(R.drawable.ic_launcher_background, "image 2"));
        data.add(new PhotoItem(R.drawable.ic_launcher_background, "image 2"));
        photoAdapter.submitList(data);
    }
}