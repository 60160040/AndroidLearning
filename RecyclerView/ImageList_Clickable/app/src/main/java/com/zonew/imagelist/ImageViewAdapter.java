package com.zonew.imagelist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ImageViewAdapter extends RecyclerView.Adapter<ImageViewHolder> {
    int[] imgs;

    // Constructor
    public ImageViewAdapter(int[] ims){
        imgs = ims;
    }

    // สร้าง View Holder
    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li;
        li = LayoutInflater.from(parent.getContext());
        View v = li.inflate(R.layout.image_item_layout,parent,false);
        ImageViewHolder ivh = new ImageViewHolder(parent.getContext(),v,imgs);
        return ivh;
    }

    // ส่วนที่เอามาแสดงผลแต่ละอัน
    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        holder.ivImage.setImageResource(imgs[position]); // show Image
        holder.tvTitle.setText("Image: "+position);      // show Text
    }

    // นับขนาด
    @Override
    public int getItemCount() {
        return imgs.length;
    }
}
