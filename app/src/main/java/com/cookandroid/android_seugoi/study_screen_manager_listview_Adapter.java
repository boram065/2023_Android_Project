package com.cookandroid.android_seugoi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class study_screen_manager_listview_Adapter extends BaseAdapter {
    List<study_screen_manager_items> items = null;
    Context context;

    public study_screen_manager_listview_Adapter(List<study_screen_manager_items> items, Context context) {
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
    public View getView(int i, View convertview, ViewGroup viewGroup) {
        // Infalter 구현
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.study_screen_manager_listview, viewGroup, false);

        // ListView의 Item을 구성하는 뷰 연결
        TextView title = view.findViewById(R.id.txtStudyTitle);
        TextView day = view.findViewById(R.id.txtDay);

        // ListView의 Item을 구성하는 뷰 세팅
        study_screen_manager_items item = items.get(i);
        title.setText(item.getTxtStudyTitle());
        day.setText(item.getTxtDay());

        return view;
    }
}