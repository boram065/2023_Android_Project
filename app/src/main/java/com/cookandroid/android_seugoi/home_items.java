package com.cookandroid.android_seugoi;

public class home_items {
    String studyName, hashTag, day;

    public home_items(String studyName, String hashTag, String day) {
        this.studyName = studyName;
        this.hashTag = hashTag;
        this.day = day;
    }

    public String getStudyName() {
        return studyName;
    }

    public String getHashTag() {
        return hashTag;
    }

    public String getDay() {
        return day;
    }
}
