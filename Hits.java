package com.apiprojects.musicapp.RetrofitModel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Hits {

    public Songs getSongs() {
        return songs;
    }

    public void setSongs(Songs songs) {
        this.songs = songs;
    }

    @SerializedName("result")
    Songs songs;
}
