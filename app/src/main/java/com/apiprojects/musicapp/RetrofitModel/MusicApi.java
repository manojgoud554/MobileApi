package com.apiprojects.musicapp.RetrofitModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface MusicApi {
    @Headers({
            "x-rapidapi-host: genius.p.rapidapi.com",
            "x-rapidapi-key: yC8pYJk6G3msh2OYqahOybGVIVe2p14EBYmjsnJDXb24vgpp20",
            "content-type:application/x-www-form-urlencoded"
    })
    @GET("artists/16775/songs")
    Call<ResponseModel> songs();



    @Headers({
            "x-rapidapi-host: genius.p.rapidapi.com",
            "x-rapidapi-key: yC8pYJk6G3msh2OYqahOybGVIVe2p14EBYmjsnJDXb24vgpp20",
            "content-type:application/x-www-form-urlencoded"
    })
    @GET("search?q=canada")
    Call<ResponseModel> search();


    @Headers({
            "x-rapidapi-host: music-credits2.p.rapidapi.com",
            "x-rapidapi-key: yC8pYJk6G3msh2OYqahOybGVIVe2p14EBYmjsnJDXb24vgpp20",
            "content-type:application/x-www-form-urlencoded"
    })
    @GET("api/c/v2/artist/id/1634093/credits")
    Call<ResponseModel> credits();


    @Headers({
            "x-rapidapi-host: shazam-core.p.rapidapi.com",
            "x-rapidapi-key: yC8pYJk6G3msh2OYqahOybGVIVe2p14EBYmjsnJDXb24vgpp20",
            "content-type:application/x-www-form-urlencoded"
    })
    @GET("v1/artists/tracks?artist_id=43328183&limit=10")
    Call<ResponseModel> tracks1();



    @Headers({
            "x-rapidapi-host: genius.p.rapidapi.com",
            "x-rapidapi-key: yC8pYJk6G3msh2OYqahOybGVIVe2p14EBYmjsnJDXb24vgpp20",
            "content-type:application/x-www-form-urlencoded"
    })
    @GET("search?q=india")
    Call<ResponseModel> tracks();




}
