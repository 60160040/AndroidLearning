package com.zonew.myprojactaffterupdate;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class MemberAdapter extends RecyclerView.Adapter<MemberViewHolder> implements Filterable {
    private Context context;
    private ArrayList<Members> listMembers;
    private ArrayList<Members> mArrayList;
    private SqliteDatabase mDatabase;

    public MemberAdapter(Context context, ArrayList<Members> listMembers) {
        this.context = context;
        this.listMembers = listMembers;
        this.mArrayList = listMembers;
        mDatabase = new SqliteDatabase(context);
    }

    @NonNull
    @NotNull
    @Override
    public MemberViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.member_list_layout, parent, false);
        return new MemberViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MemberViewHolder holder, int position) {
        final Members members = listMembers.get(position);
        holder.tvName.setText(members.getName());
        holder.tvPhoneNumber.setText(members.getPhno());
        holder.editMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTaskDialog(members);
            }
        });
        holder.deleteMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDatabase.deleteMember(members.getId());
                //ยังมีอีก
            }
        });
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    listMembers = mArrayList;
                } else {
                    ArrayList<Members> filteredList = new ArrayList<>();
                    for (Members members : mArrayList) {
                        if (members.getName().toLowerCase().contains(charString)) {
                            filteredList.add(members);
                        }
                    }
                    listMembers = filteredList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = listMembers;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                listMembers = (ArrayList<Members>) filterResults.values;
                notifyDataSetChanged();
                /////////////////
            }
        };
    }

    @Override
    public int getItemCount() {
        return listMembers.size();
    }

    private void editTaskDialog(Members members) {

    }

}
