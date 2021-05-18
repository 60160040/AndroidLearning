package com.zonew.dynamicfragement;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SecondFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecondFragment extends Fragment {
    EditText et; // กล่องข้อความ
    TextView tvDip; // show Message

    public SecondFragment() {
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
        View v = inflater.inflate(R.layout.fragment_second, container, false);

        // รับข้อมูลมาจาก Fragment อื่น
        Bundle bd = getArguments()                ; // Fragment รับข้อมูลเป็น Bundle, Activity รับเป็น Intent
        String str = bd.getString("MESSAGE1"); // เอา [String]
        tvDip = v.findViewById(R.id.idTvDispMsg); // เชื่อมกับ Layout
        tvDip.setText(str);

        et = v.findViewById(R.id.idEtMsg2);

        Button b =  v.findViewById(R.id.idBtn3);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = MainActivity.fm;
                FragmentTransaction ft = fm.beginTransaction();
                ThirdFragment frag3 = new ThirdFragment();

                // Send data
                String str = et.getText().toString();
                Bundle bd = new Bundle();
                bd.putString("MESSAGE2",str);
                frag3.setArguments(bd);

                ft.replace(R.id.idFragmentBox,frag3);           // เปลี่ยนเ Fragment
                ft.addToBackStack(null);                        // เอาไว้กด back กลับ
                ft.commit();
            }
        });
        return v;
    }
}