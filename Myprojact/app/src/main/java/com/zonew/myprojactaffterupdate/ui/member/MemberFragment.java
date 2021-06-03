package com.zonew.myprojactaffterupdate.ui.member;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.zonew.myprojactaffterupdate.MemberAdapter;
import com.zonew.myprojactaffterupdate.Members;
import com.zonew.myprojactaffterupdate.R;
import com.zonew.myprojactaffterupdate.SqliteDatabase;
import com.zonew.myprojactaffterupdate.databinding.FragmentMemberBinding;

import java.util.ArrayList;

public class MemberFragment extends Fragment {
    private SqliteDatabase mDatabase;
    private MemberViewModel memberViewModel;
    private FragmentMemberBinding binding;

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
            MemberAdapter mAdapter = new MemberAdapter(getContext(), allMembers);
            memberView.setAdapter(mAdapter);
        } else {
            memberView.setVisibility(View.GONE);
            Toast.makeText(getContext(), "There is no contact in the database. Start adding now", Toast.LENGTH_LONG).show();
        }

        FloatingActionButton btnAdd = binding.floatingActionButton2;
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addTaskDialog();

            }
        });

        return root;
    }

    private void addTaskDialog() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View subView = inflater.inflate(R.layout.add_members, null);
        final EditText nameField = subView.findViewById(R.id.enterName);
        final EditText noField = subView.findViewById(R.id.enterPhoneNum);
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Add new MEMBER");
        builder.setView(subView);
        builder.create();
        builder.setPositiveButton("ADD MEMBER", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final String name = nameField.getText().toString();
                final String ph_no = noField.getText().toString();
                if (TextUtils.isEmpty(name)) {
                    Toast.makeText(getContext(), "Something went wrong. Check your input values", Toast.LENGTH_LONG).show();
                } else {
                    Members newMember = new Members(name, ph_no);
                    mDatabase.addMembers(newMember);
                    // Reload current fragment
                    /*Fragment frg = null;
                    frg = getParentFragmentManager().findFragmentByTag("Your_Fragment_TAG");
                    final FragmentTransaction ft = getParentFragmentManager().beginTransaction();
                    ft.detach(frg);
                    ft.attach(frg);
                    ft.commit();*/

//                    from net
//                    finish();
//                    startActivity(getIntent());
                }
            }
        });
        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getContext(), "Task cancelled", Toast.LENGTH_LONG).show();
            }
        });
        builder.show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}