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

import com.apiprojects.musicapp.CreditsAdapter;
import com.apiprojects.musicapp.MusicAdapter;
import com.apiprojects.musicapp.R;
import com.apiprojects.musicapp.RetrofitModel.MusicApi;
import com.apiprojects.musicapp.RetrofitModel.ResponseModel;
import com.apiprojects.musicapp.RetrofitModel.Songs;
import com.apiprojects.musicapp.ServiceGenerator;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;


public class CreditsFragment extends Fragment {
    private RecyclerView recyclerView;
    //MovieAdapter movieAdapter;
    CreditsAdapter creditsAdapter;
    public static CreditsFragment creditsFragment() {
        CreditsFragment fragment = new CreditsFragment();
        return fragment;
    }
    Button test;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_credits, container, false);
        recyclerView=view.findViewById(R.id.songs_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        creditsAdapter=new CreditsAdapter();
        recyclerView.setAdapter(creditsAdapter);


        getPopularMovies();
        return view;
    }

    private  void getPopularMovies(){
        ArrayList<Songs> songs=new ArrayList<Songs>();
        MusicApi movieApi= ServiceGenerator.getMusicApi();
        Call<ResponseModel> responseCall=movieApi.credits();
        responseCall.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, retrofit2.Response<ResponseModel> response) {
                Log.d("responsebody",response.body().toString());
                ResponseModel responseModel=response.body();
                for(int i=0;i<responseModel.getData().getCreditsList().size();i++){
                    songs.add(responseModel.getData().getCreditsList().get(i).getSongs());
                    Log.d("responsebody",responseModel.getData().getCreditsList().get(i).getSongs().getAlbumTitle());
                }

                creditsAdapter.updateData(songs);
               // creditsAdapter.updateData(responseModel.getResponse().getSongsList());



            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

            }
        });

    }
}
