package com.localhost.shobhitjain.songza;

import android.content.Context;
import android.os.Environment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

import cn.aigestudio.downloader.bizs.DLManager;
import cn.aigestudio.downloader.interfaces.SimpleDListener;

/**
 * Created by shobhitjain on 16/12/15.
 */
public class SongRecyclerViewAdapter extends RecyclerView.Adapter<SongRecyclerViewAdapter.ViewHolder>{

    private List<Song> items;
    Context mContext;
    private String saveDir;
    private ProgressBar[] pbDLs;




    public SongRecyclerViewAdapter() {
        this.items = Collections.emptyList();
    }

    public List<Song> getItems() {
        return items;
    }

    public void setItems(List<Song> items,Context context) {
        this.items = items;
        this.mContext=context;
    }

    public SongRecyclerViewAdapter(List<Song> items) {
        this.items = items;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_repository, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        final Song song = items.get(position);
        holder.textView.setText(song.getTitle());
        Picasso.with(mContext).load(song.getThumbnail()).into(holder.imageView);
        holder.downloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DLManager.getInstance(mContext).dlStart(song.getDl(), Environment.getExternalStorageDirectory() + "/ShobhitSOngs/",null,null,
                        new SimpleDListener(){

                            @Override
                            public void onProgress(int progress) {
                                holder.progressBar.setProgress(progress);
                            }

                            @Override
                            public void onStart(String fileName, String realUrl, int fileLength) {
                                holder.progressBar.setMax(fileLength);
                            }
                        });

            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public ImageView imageView;
        public Button downloadButton;
        public ProgressBar progressBar;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.SongName);
            imageView=(ImageView) itemView.findViewById(R.id.SongImage);
            downloadButton =(Button) itemView.findViewById(R.id.DownloadButton);
            progressBar =(ProgressBar) itemView.findViewById(R.id.ProgressBarDownload);

        }
    }
}
