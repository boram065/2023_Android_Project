package com.cookandroid.android_seugoi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class home_listview_Adapter extends ArrayAdapter<home_items> {
    public home_listview_Adapter(Context context, ArrayList<home_items> studyList) {
        super(context, 0, studyList);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        home_items studyItem = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.home_listview, parent, false);
        }

        // Lookup view for data population
        TextView studyName = convertView.findViewById(R.id.studyName);

        // Populate the data into the template view using the data object
        if (studyItem != null) {
            studyName.setText(studyItem.getStudyName());
        }

        return convertView;
    }
}
