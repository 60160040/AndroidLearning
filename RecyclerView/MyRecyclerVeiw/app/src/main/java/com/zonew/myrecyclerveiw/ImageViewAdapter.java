package com.zonew.myrecyclerveiw;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ImageViewAdapter  extends  RecyclerView.Adapter<ImageViewHolder>{
    int[]   imgs;

    public ImageViewAdapter(int[] img){
        imgs = img;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li;
        li = LayoutInflater.from(parent.getContext());
        View v = li.inflate(R.layout.word_item_layout,parent,false);
        ImageViewHolder ivh = new ImageViewHolder(parent.getContext(),v,imgs);
        return ivh;
    }

    // เชื่อม data ที่เอามาแสดงแต่ละอัน
    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        holder.ivImage.setImageResource(imgs[position]); // show Image
        holder.tvTitle.setText("Image: "+position);      // show Text
    }

    @Override
    public int getItemCount() {
        return imgs.length;
    }
}
