package com.zonew.imagelist;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ImageViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{
    ImageView ivImage;
    TextView tvTitle;
    Context ct;
    int[] ims;

    public ImageViewHolder(Context c, @NonNull View itemView,int[] im) {
        super(itemView);

        ivImage = itemView.findViewById(R.id.idIvImage);
        tvTitle = itemView.findViewById(R.id.idTvTitle);

        itemView.setOnClickListener(this);               // เมื่อมีการคลิก [itemView]
        ct = c;
        ims = im;

    }

    @Override
    public void onClick(View view) {
        Toast.makeText(ct,"Hello",Toast.LENGTH_SHORT).show(); // พารามิเตอร์แรกต้องเป็นหน้า Activity (ui)

        Intent i = new Intent(ct,DisplayImageActivity.class);
        int id = getBindingAdapterPosition();                      // เอาตำแหน่งรุปที่คลิก
        int resId= ims[id];                                        // เอารุปที่อยู่รูป ณ ตำแหน่ง (position)
        i.putExtra("IMAGE_RES_ID",resId);                   // ส่งรูปไป
        ct.startActivity(i);
    }
}
