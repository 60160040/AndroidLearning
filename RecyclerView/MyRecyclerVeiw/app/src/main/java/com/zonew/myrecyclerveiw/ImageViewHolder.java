package com.zonew.myrecyclerveiw;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    ImageView ivImage;
    TextView tvTitle;
    Context ct;
    int[] ims;

    public ImageViewHolder(Context c, @NonNull View itemView,int[] im) {
        super(itemView);

        // เชื่อมกับ word_item_layout.xml
        ivImage = itemView.findViewById(R.id.idIvImage);
        tvTitle = itemView.findViewById(R.id.idTvTitle);

        //ดักฟัง itemView (onClick ที่ ItemView[ราบการ])
        itemView.setOnClickListener(this);               // เมื่อมีการคลิก [itemView]
        ct = c;
        ims = im;


    }

    @Override
    public void onClick(View view) {
        Intent i     = new Intent(ct,DisplayActivity.class) ;
        int    id    = getBindingAdapterPosition()          ;
        int resId = ims[id]                                 ;
        i.putExtra("IMAGE_RES_ID",resId)              ;

        Toast.makeText(ct,"Image : "+ id,Toast.LENGTH_SHORT).show(); // พารามิเตอร์แรกต้องเป็นหน้า Activity (ui)
        ct.startActivity(i)                                 ;

    }
}
