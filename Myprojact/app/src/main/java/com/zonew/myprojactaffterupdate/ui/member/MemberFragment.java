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

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.zonew.myprojactaffterupdate.AddMemberActivity;
import com.zonew.myprojactaffterupdate.R;
import com.zonew.myprojactaffterupdate.SqliteDatabase;
import com.zonew.myprojactaffterupdate.databinding.FragmentMemberBinding;

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

        tvMember = root.findViewById(R.id.idTvMemberDisplay);

        // default template
        /*final TextView textView = binding.textMember;
        memberViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/

        FloatingActionButton b = binding.floatingActionButton2;
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), AddMemberActivity.class);
                startActivity(i);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}