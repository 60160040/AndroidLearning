package com.zonew.myprojactaffterupdate;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.zonew.myprojactaffterupdate.ui.member.MemberFragment;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Objects;

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
                editMemberLayout(members);
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
            }
        };
    }

    @Override
    public int getItemCount() {
        return listMembers.size();
    }

    private void editMemberLayout(final Members members) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View subView = inflater.inflate(R.layout.add_members, null);
        final EditText nameField = subView.findViewById(R.id.enterName);
        final EditText phoneNoField = subView.findViewById(R.id.enterPhoneNum);
        if (members != null) {
            nameField.setText(members.getName());
            phoneNoField.setText(String.valueOf(members.getPhno()));
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Edit member");
        builder.setView(subView);
        builder.create();
        builder.setPositiveButton("EDIT MEMBER", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final String name = nameField.getText().toString();
                final String ph_no = phoneNoField.getText().toString();
                if (TextUtils.isEmpty(name)) {
                    Toast.makeText(context, "Something went wrong. Check your input values", Toast.LENGTH_LONG).show();
                } else {
                    mDatabase.updateMembers(new
                            Members(Objects.requireNonNull(members).getId(), name, ph_no));
                    ((Activity) context).finish();
                    context.startActivity(((Activity)
                            context).getIntent());
                }
            }
        });
        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, "Task cancelled", Toast.LENGTH_LONG).show();
            }
        });
        builder.show();
    }

}
