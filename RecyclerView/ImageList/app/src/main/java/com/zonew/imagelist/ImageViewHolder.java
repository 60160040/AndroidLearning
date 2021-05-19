package com.zonew.imagelist;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ImageViewHolder extends RecyclerView.ViewHolder {
    ImageView ivImage;
    TextView tvTitle;
    public ImageViewHolder(@NonNull View itemView) {
        super(itemView);

        ivImage = itemView.findViewById(R.id.idIvImage);
        tvTitle = itemView.findViewById(R.id.idTvTitle);
    }
}
