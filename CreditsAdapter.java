package com.apiprojects.musicapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apiprojects.musicapp.RetrofitModel.Songs;
import com.bumptech.glide.Glide;

import java.util.List;

public class CreditsAdapter extends RecyclerView.Adapter<CreditsAdapter.CreditsViewHolder> {
    List<Songs> songs;

    @NonNull
    @Override
    public CreditsAdapter.CreditsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.credits_list, parent, false);
        return new CreditsAdapter.CreditsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CreditsAdapter.CreditsViewHolder holder, int position) {
        holder.albumTitle.setText("Album Title : "+songs.get(position).getAlbumTitle());
        holder.releaseDate.setText("Release Date : "+songs.get(position).getReleaseDate());
        holder.trackCount.setText("Track Count : "+songs.get(position).getTrackCount());

        Glide.with(holder.itemView.getContext()).load(songs.get(position).getAlbumArt()).into(holder.music_img);
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

    public class CreditsViewHolder extends RecyclerView.ViewHolder {

        ImageView music_img;
        TextView albumTitle;
        TextView releaseDate;
        TextView trackCount;



        public CreditsViewHolder(@NonNull View itemView) {
            super(itemView);

            music_img = itemView.findViewById(R.id.music_img);
            albumTitle = itemView.findViewById(R.id.albumTitle);
            releaseDate = itemView.findViewById(R.id.releaseDate);
            trackCount = itemView.findViewById(R.id.trackCount);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }
}
