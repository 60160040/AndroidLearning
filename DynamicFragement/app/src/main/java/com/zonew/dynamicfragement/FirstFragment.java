package com.zonew.dynamicfragement;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class FirstFragment extends Fragment {


    public FirstFragment() {
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
        View v = inflater.inflate(R.layout.fragment_first, container, false); //  เปลี่ยน return เป็น "View v = "
        // เชื่อม Fragment
        Button b =  v.findViewById(R.id.idBtn2);  // สร้าง[ปุ่ม]เชื่อมกับ UI

        // Create onClick
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = MainActivity.fm;           // เชื่อม Fragment กับ MainActivity
                FragmentTransaction ft = fm.beginTransaction(); // สร้างตัวเปลี่ยนหน้า Fragment
                SecondFragment frag2 = new SecondFragment();    // สร้างหน้าที่เปลี่ยน
                ft.replace(R.id.idFragmentBox,frag2);           // ดึงหน้า Fragment ที่จะเปลี่ยนมา
                ft.addToBackStack(null);                        // เอาไว้กด back กลับ
                ft.commit();                                    // เริ่มทำงานได้
            }
        });
        return v;
    }
}

// go to page 2
//    public void go2(View v) {
//        FragmentManager fm = MainActivity.fm;
//        FragmentTransaction ft = fm.beginTransaction();
//        SecondFragment frag2 = new SecondFragment();
//        ft.replace(R.id.idFragmentBox,frag2);           // เปลี่ยนเ Fragment
//        ft.commit();
//    }