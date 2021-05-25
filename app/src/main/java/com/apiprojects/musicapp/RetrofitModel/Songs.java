package com.apiprojects.musicapp.RetrofitModel;

import com.google.gson.annotations.SerializedName;

public class Songs {
    public Songs(String full_title, String song_art_image_url, String albumTitle, String albumArt, String releaseDate, String trackCount, long id) {
        this.full_title = full_title;
        this.song_art_image_url = song_art_image_url;
        this.albumTitle = albumTitle;
        this.albumArt = albumArt;
        this.releaseDate = releaseDate;
        this.trackCount = trackCount;
        this.id = id;
    }

    public String getFull_title() {
        return full_title;
    }

    public void setFull_title(String full_title) {
        this.full_title = full_title;
    }

    public String getSong_art_image_url() {
        return song_art_image_url;
    }

    public void setSong_art_image_url(String song_art_image_url) {
        this.song_art_image_url = song_art_image_url;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public String getAlbumArt() {
        return albumArt;
    }

    public void setAlbumArt(String albumArt) {
        this.albumArt = albumArt;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTrackCount() {
        return trackCount;
    }

    public void setTrackCount(String trackCount) {
        this.trackCount = trackCount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    String full_title;
    String song_art_image_url;


    @SerializedName("albumTitle")
    String albumTitle;
    @SerializedName("albumArt")
    String albumArt;
    @SerializedName("releaseDate")
    String releaseDate;
    String trackCount;
    long id;


}
