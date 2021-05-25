package com.apiprojects.musicapp.RetrofitModel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {

    public List<Credits> getCreditsList() {
        return creditsList;
    }

    public void setCreditsList(List<Credits> creditsList) {
        this.creditsList = creditsList;
    }

    @SerializedName("credits")
    List<Credits> creditsList;
}
