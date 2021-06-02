package com.zonew.myprojactaffterupdate.ui.member;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.zonew.myprojactaffterupdate.AddMemberActivity;
import com.zonew.myprojactaffterupdate.Members;
import com.zonew.myprojactaffterupdate.R;
import com.zonew.myprojactaffterupdate.SqliteDatabase;
import com.zonew.myprojactaffterupdate.databinding.FragmentMemberBinding;

import java.util.ArrayList;

public class MemberFragment extends Fragment {
    private SqliteDatabase mDatabase;
    private MemberViewModel memberViewModel;
    private FragmentMemberBinding binding;

    TextView tvMember;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        memberViewModel =
                new ViewModelProvider(this).get(MemberViewModel.class);

        binding = FragmentMemberBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        RecyclerView memberView = root.findViewById(R.id.myMemberList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        memberView.setLayoutManager(linearLayoutManager);
        memberView.setHasFixedSize(true);
        mDatabase = new SqliteDatabase(getContext());
        ArrayList<Members> allMembers = mDatabase.listMembers();
        if (allMembers.size() > 0) {
            memberView.setVisibility(View.VISIBLE);

        }

        FloatingActionButton b = binding.floatingActionButton2;
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), AddMemberActivity.class);
                startActivity(i);
            }
        });
//
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}