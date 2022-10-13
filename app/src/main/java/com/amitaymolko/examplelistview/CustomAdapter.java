package com.amitaymolko.examplelistview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amitaymolko on 12/20/15.
 */
public class CustomAdapter extends BaseAdapter {

    Context context;
    ArrayList<MyItem> items;

    public CustomAdapter(Context context, ArrayList<MyItem> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item, parent, false);
            Log.d("CustomAdapter", "New View");
        }
        else {
            Log.d("CustomAdapter", "using convertView");
        }

        MyItem curItem = items.get(position);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.iconImageView);
        TextView textView = (TextView) convertView.findViewById(R.id.titleTextView);

        imageView.setImageResource(curItem.getIconId());
        textView.setText(curItem.getText());

        return convertView;
    }

}
