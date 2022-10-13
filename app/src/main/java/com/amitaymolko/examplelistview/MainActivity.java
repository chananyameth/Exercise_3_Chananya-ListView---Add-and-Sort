package com.amitaymolko.examplelistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private final int ItemRequestCode = 1;

    ListView listView;
    CustomAdapter listAdapter;
    ArrayList<MyItem> items = new ArrayList<MyItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listview);

        items.add(new MyItem(R.drawable.alligator_48, "alligator"));
        items.add(new MyItem(R.drawable.ant_48, "ant"));
        items.add(new MyItem(R.drawable.bear_48, "bear"));
        items.add(new MyItem(R.drawable.beaver_48, "beaver"));
        items.add(new MyItem(R.drawable.cat_48, "cat"));
        items.add(new MyItem(R.drawable.cow_48, "cow"));
        items.add(new MyItem(R.drawable.crab_48, "crab"));
        items.add(new MyItem(R.drawable.wolf_48, "wolf"));
        items.add(new MyItem(R.drawable.wasp_48, "wasp"));
        items.add(new MyItem(R.drawable.snail_48, "snail"));
        items.add(new MyItem(R.drawable.shark_48, "shark"));

        listAdapter = new CustomAdapter(this, items);
        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MainActivity.this, ItemActivity.class);
                i.putExtra("item", items.get(position));
                i.putExtra("itemPosition", position);
                startActivityForResult(i, ItemRequestCode);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.addItem:
                addRandomItem();
                break;
            case R.id.sortList:
                sortList();
                break;
        }
        return true;
    }


    private void addRandomItem() {
        Random random = new Random();
        int randomIndex = Math.abs(random.nextInt()) % items.size();
        MyItem randomItem = items.get(randomIndex);
        items.add(new MyItem(randomItem.getIconId(), randomItem.getText()));
        listAdapter.notifyDataSetChanged();
    }

    private void sortList() {
        Collections.sort(items);
        listAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case ItemRequestCode:
                if (resultCode == RESULT_OK) {
                    MyItem item = (MyItem) data.getSerializableExtra("item");
                    int itemPosition = data.getIntExtra("itemPosition", -1);
                    if (item == null || itemPosition == -1) {
                        return;
                    }
                    items.set(itemPosition, item);
                    listAdapter.notifyDataSetChanged();
                }
                break;
        }
    }
}
