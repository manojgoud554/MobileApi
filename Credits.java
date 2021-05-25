package com.apiprojects.musicapp.RetrofitModel;

import com.google.gson.annotations.SerializedName;

public class Credits {

    public Songs getSongs() {
        return songs;
    }

    public void setSongs(Songs songs) {
        this.songs = songs;
    }

    @SerializedName("album")
    Songs songs;
}
