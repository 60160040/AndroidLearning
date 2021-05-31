package com.zonew.myprojactaffterupdate.ui.member;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.zonew.myprojactaffterupdate.databinding.FragmentMemberBinding;

public class MemberFragment extends Fragment {

    private MemberViewModel memberViewModel;
    private FragmentMemberBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        memberViewModel =
                new ViewModelProvider(this).get(MemberViewModel.class);

        binding = FragmentMemberBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

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
//                Intent i = new Intent(getContext(),"AddActivity.class");
//                startActivity(i);
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