package vn.linh.androidrecyclerviewmultipleitemtype.screen.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import java.util.ArrayList;
import vn.linh.androidrecyclerviewmultipleitemtype.R;

public class MainActivity extends AppCompatActivity implements MultipleItemTypeAdapter.ItemClickListener{
    private RecyclerView mRecyclerView;
    private MultipleItemTypeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Multiple PhotoItem Type Recycler List");

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        ArrayList<Item> data = new ArrayList<>();
        data.add(new Item("a", "b"));
        data.add(new Item("c", "b"));
        data.add(new Item("d", "b"));
        data.add(new Item("e", "b"));
        data.add(new Item("f", "b"));
        data.add(new Item("g", "b"));
        data.add(new Item("h", "b"));
        data.add(new Item("j", "b"));
        data.add(new Item("k", "b"));
        data.add(new Item("l", "b"));
        data.add(new Item("m", "b"));

        // set up the RecyclerView
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MultipleItemTypeAdapter(this, data.toArray(new Item[data.size()]));
        adapter.setClickListener(this);
        mRecyclerView.setAdapter(adapter);

        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    @Override
    public void onItemClick(View view, int position) {

    }
}