package com.cookandroid.android_seugoi;

import android.content.Context;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class home_listview_Adapter extends BaseAdapter {
    List<home_items> items = null;
    Context context;

    public home_listview_Adapter(List<home_items> items, Context context) {
        this.items = items;
        this.context = context;
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
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.home_listview, parent, false);

        TextView title = view.findViewById(R.id.studyName);
        TextView hashTag = view.findViewById(R.id.hashTag);
        TextView day = view.findViewById(R.id.txtDay);

        home_items item = items.get(position);
        title.setText(item.getStudyName());
        hashTag.setText(item.getHashTag());
        day.setText(item.getDay());

        return view;
    }
}
