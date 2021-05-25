package com.apiprojects.musicapp.RetrofitModel;

import com.google.gson.annotations.SerializedName;

public class ResponseModel {
    @SerializedName("response")
    Response response;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @SerializedName("data")
    Data data;
}
