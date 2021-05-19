package com.zonew.wordlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    RecyclerView               rv ;  // หน้า RecyclerView
    RecyclerView.LayoutManager lm ;  // อยู่ใน RecyclerView

    LinkedList<String>   wordList ;  // data

    WordListAdapter           wla ;  // เอาไว้เชื่อมกัน Adapter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState)          ;
        setContentView(R.layout.activity_main)      ;

        // สร้าง list data เอาไว้เรียก
        wordList = new LinkedList<String>();
            for (int i=0;i<30;i++){
            wordList.addLast("Word No. " +i)     ;
        }

        // เชื่อมตัวแปร RecyclerView
        rv = findViewById(R.id.idRvWordListView)    ;

        // ประกอบ Activity (LinearLayout ใส่ใน RecyclerView)
        lm = new LinearLayoutManager(this)  ; // ทำ [lm] เป็น Linear
        rv.setLayoutManager(lm)                     ; // แล้วเอาใส่ [rv]

        // เชื่อม Adapter
        wla = new WordListAdapter(this,wordList) ; // สร้างและเอา Data [wordList] มาใส่ Adapter [wla]
        rv.setAdapter(wla)                          ; // เอา Adapter [wla] มาเชื่อมกัน RecyclerView [rv]
    }
}
