package com.apoorvarajbhadani.musiclist.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apoorvarajbhadani.musiclist.Models.MusicModel;
import com.apoorvarajbhadani.musiclist.R;

import java.util.List;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.MusicViewHolder> {

    private Context mCtx;
    private List<MusicModel> musicModelList;

    public MusicAdapter(Context mCtx, List<MusicModel> musicModelList){
        this.mCtx = mCtx;
        this.musicModelList = musicModelList;
    }

    @NonNull
    @Override
    public MusicAdapter.MusicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recycler_view_item_layout,parent,false);
        return new MusicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicAdapter.MusicViewHolder holder, int position) {
        String title = musicModelList.get(position).getTitle();
        String desc = musicModelList.get(position).getDesc();
        holder.titleTextView.setText(title);
        holder.descTextView.setText(desc);
    }

    @Override
    public int getItemCount() {
        return musicModelList.size();
    }

    public class MusicViewHolder extends RecyclerView.ViewHolder{
        TextView titleTextView,descTextView;
        public MusicViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = (TextView)itemView.findViewById(R.id.item_title_textview);
            descTextView = (TextView)itemView.findViewById(R.id.item_desc_textview);
        }
    }
}
