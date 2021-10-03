package com.example.audiorecorder;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;

public class AudioListAdapter extends RecyclerView.Adapter<AudioListAdapter.AudioViewHolder> {
    private File[] allFiles;
    private TimeAgo timeAgo;

    private onItemListClick onItemListClick;

    public AudioListAdapter(File[] allFiles, onItemListClick onItemListClick){
        this.allFiles = allFiles;
        this.onItemListClick = onItemListClick;
    }

    @NonNull
    @Override
    public AudioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_list_item, parent, false);
        timeAgo = new TimeAgo();
        return new AudioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AudioViewHolder holder, int position) {
        String title = allFiles[position].getName().replaceAll(".3gp", "");
        holder.listTitle.setText(title);
        holder.listDate.setText(timeAgo.getTimeAgo(allFiles[position].lastModified()));
    }

    @Override
    public int getItemCount() {
        return allFiles.length;
    }

    public class AudioViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView listImage;
        private TextView listTitle, listDate;

        public AudioViewHolder(@NonNull View itemView) {
            super(itemView);

            listImage = itemView.findViewById(R.id.list_image_view);
            listTitle = itemView.findViewById(R.id.list_title);
            listDate = itemView.findViewById(R.id.list_date);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            onItemListClick.onClickListener(allFiles[getAdapterPosition()], getAdapterPosition());
        }
    }

    public interface onItemListClick{
        void onClickListener(File file, int position);
    }

}
