package com.zonew.dynamicfragement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static FragmentManager fm;  // เอาไว้ให้หน้าอื่นเรียกได้

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction(); // สร้างตัวเปลี่ยนหน้า Fragment
        FirstFragment frag1 = new FirstFragment();      // สร้างหน้าที่จะเปลี่ยน
        ft.add(R.id.idFragmentBox,frag1);               // ดึงหน้า Fragment ที่จะเปลี่ยนมา
        ft.commit();                                    // เริ่มทำงานได้
    }

}