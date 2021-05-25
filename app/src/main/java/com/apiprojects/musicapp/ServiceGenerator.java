package com.apiprojects.musicapp;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private static Retrofit.Builder builder = new Retrofit.Builder().baseUrl(Credentials.Base_Url).addConverterFactory(GsonConverterFactory.create());
    private static Retrofit retrofit=builder.build();

    private  static MusicApi movieApi=retrofit.create(MusicApi.class);
    public static MusicApi getMusicApi(){
        return movieApi;
    }
}
