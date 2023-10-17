package com.cookandroid.android_seugoi;

import java.util.Calendar;

public class study_screen_manager_items {
    String txtStudyTitle, txtDay;

    public study_screen_manager_items(String txtStudyTitle, String txtDay) {
        this.txtStudyTitle = txtStudyTitle;
        this.txtDay = txtDay;
    }

    public String getTxtStudyTitle() {
        return txtStudyTitle;
    }

    public String getTxtDay() {
        return txtDay;
    }
}