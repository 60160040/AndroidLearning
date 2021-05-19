package com.zonew.wordlist;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

// เชื่อมหน้า Activity (word_item_layout.xml)
public class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    TextView tvWordItem; // ตรงกับ layout ที่เตรียมไว้
    Context ct;

    public WordViewHolder(Context c, @NonNull View itemView) {
        super(itemView);

        // เชื่อมกับ word_item_layout.xml
        tvWordItem = itemView.findViewById(R.id.idTvWordItem);

        //ดักฟัง itemView (onClick ที่ ItemView[ราบการ])
        itemView.setOnClickListener(this);
        ct = c ;
    }

    @Override
    public void onClick(View view) {
        int id = getAdapterPosition();
        Toast.makeText(ct,"Hello : "+id,Toast.LENGTH_SHORT).show();
    }
}
