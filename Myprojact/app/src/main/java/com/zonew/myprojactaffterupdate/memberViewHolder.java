package com.zonew.myprojactaffterupdate;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

public class memberViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    TextView tvPhoneNumber,tvName;
    public memberViewHolder(Context c, @NonNull @NotNull View itemView,int[] im) {
        super(itemView);

        tvPhoneNumber = itemView.findViewById(R.id.idTvPhoneNumber);
        tvName        = itemView.findViewById(R.id.idTvName);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }
}
