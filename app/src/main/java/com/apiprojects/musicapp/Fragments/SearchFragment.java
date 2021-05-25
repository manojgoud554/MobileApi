package com.apiprojects.musicapp.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.apiprojects.musicapp.R;
import com.apiprojects.musicapp.RetrofitModel.Songs;
import com.apiprojects.musicapp.ServiceGenerator;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;


public class SearchFragment extends Fragment {
    private RecyclerView recyclerView;
    //MovieAdapter movieAdapter;
    MusicAdapter musicAdapter;
    public static SearchFragment searchFragment() {
        SearchFragment fragment = new SearchFragment();
        return fragment;
    }
    Button test;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        recyclerView=view.findViewById(R.id.songs_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        musicAdapter=new MusicAdapter();
        recyclerView.setAdapter(musicAdapter);


        getPopularMovies();
        return view;
    }

    private  void getPopularMovies(){
        ArrayList<Songs> songs=new ArrayList<Songs>();
        MusicApi movieApi= ServiceGenerator.getMusicApi();
        Call<ResponseModel> responseCall=movieApi.search();
        responseCall.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, retrofit2.Response<ResponseModel> response) {
                Log.d("responsebody",response.body().toString());
                ResponseModel responseModel=response.body();
                for(int i=0;i<responseModel.getResponse().getHitsList().size();i++){
                    songs.add(responseModel.getResponse().getHitsList().get(i).getSongs());
                    Log.d("responsebody",responseModel.getResponse().getHitsList().get(i).getSongs().getFull_title());
                }
                musicAdapter.updateData(songs);



            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

            }
        });

    }
}
