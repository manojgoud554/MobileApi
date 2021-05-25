package com.apiprojects.musicapp.RetrofitModel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Response {
    @SerializedName("songs")
    List<Songs> songsList;


    public List<Hits> getHitsList() {
        return hitsList;
    }

    public void setHitsList(List<Hits> hitsList) {
        this.hitsList = hitsList;
    }

    @SerializedName("hits")
    List<Hits> hitsList;

    public List<Songs> getSongsList() {
        return songsList;
    }

    public void setSongsList(List<Songs> songsList) {
        this.songsList = songsList;
    }



}
