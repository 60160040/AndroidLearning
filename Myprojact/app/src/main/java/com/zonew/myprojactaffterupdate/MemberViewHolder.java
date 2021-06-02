package com.zonew.myprojactaffterupdate;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import androidx.annotation.NonNull;

import org.jetbrains.annotations.NotNull;

public class MemberViewHolder extends RecyclerView.ViewHolder {
    TextView tvPhoneNumber, tvName;
    ImageView deleteMember;
    ImageView editMember;

    public MemberViewHolder(View itemView) {
        super(itemView);

        tvName = itemView.findViewById(R.id.memberName);
        tvPhoneNumber = itemView.findViewById(R.id.phoneNum);
        deleteMember = itemView.findViewById(R.id.deleteMember);
        editMember = itemView.findViewById(R.id.editMember);
    }

}
