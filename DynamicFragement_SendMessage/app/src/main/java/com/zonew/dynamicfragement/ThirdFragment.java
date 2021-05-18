package com.zonew.dynamicfragement;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ThirdFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ThirdFragment extends Fragment {
    TextView tvShow;

    public ThirdFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_third, container, false);

        // รับข้อมูลมาจาก Fragment อื่น
        Bundle bd = getArguments()                ; // Fragment รับข้อมูลเป็น Bundle, Activity รับเป็น Intent
        String str = bd.getString("MESSAGE2"); // เอา [String]
        tvShow = v.findViewById(R.id.idTvDispMsg); // เชื่อมกับ Layout
        tvShow.setText(str);

        Button b =  v.findViewById(R.id.idBtn);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = MainActivity.fm;
                FragmentTransaction ft = fm.beginTransaction();
                FirstFragment frag1 = new FirstFragment();
                ft.replace(R.id.idFragmentBox,frag1);           // เปลี่ยนเ Fragment

                ft.commit();
            }
        });
        return v;
    }
}