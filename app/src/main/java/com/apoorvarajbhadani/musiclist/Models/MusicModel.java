package com.apoorvarajbhadani.musiclist.Models;

import com.google.gson.annotations.SerializedName;

public class MusicModel {
    @SerializedName("title")
    String title;
    @SerializedName("desc")
    String desc;

    public MusicModel(String title, String desc) {
        this.title = title;
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }
}
