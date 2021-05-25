package com.apiprojects.musicapp;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.apiprojects.musicapp.RetrofitModel.Songs;

import com.bumptech.glide.Glide;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.MusicViewHolder> {
    List<Songs> songs;

    @NonNull
    @Override
    public MusicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.music_list_items, parent, false);
        return new MusicViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicViewHolder holder, int position) {
        holder.music_title.setText(songs.get(position).getFull_title());


        Glide.with(holder.itemView.getContext()).load(songs.get(position).getSong_art_image_url()).into(holder.music_img);
    }

    @Override
    public int getItemCount() {

        if(songs!=null){
            return songs.size();
        }else{
            return 0;
        }

    }

    public void updateData(List<Songs> songs) {
        this.songs = songs;
        notifyDataSetChanged();
    }

    public class MusicViewHolder extends RecyclerView.ViewHolder {

        ImageView music_img;
        TextView music_title;


        public MusicViewHolder(@NonNull View itemView) {
            super(itemView);

            music_img = itemView.findViewById(R.id.music_img);
            music_title = itemView.findViewById(R.id.music_title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }
}
