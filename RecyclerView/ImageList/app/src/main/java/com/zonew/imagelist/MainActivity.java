package com.zonew.imagelist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    RecyclerView.LayoutManager lm;
    int[] images = {R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic4,R.drawable.pic5,
            R.drawable.pic6 ,R.drawable.pic7 ,R.drawable.pic8 ,R.drawable.pic9 ,R.drawable.pic10,
            R.drawable.pic11,R.drawable.pic12,R.drawable.pic13,R.drawable.pic14,R.drawable.pic15,
            R.drawable.pic16,R.drawable.pic17,R.drawable.pic18,R.drawable.pic19,R.drawable.pic20,
            R.drawable.pic21,R.drawable.pic22,R.drawable.pic23,R.drawable.pic24,R.drawable.pic25,
            R.drawable.pic26,R.drawable.pic27,R.drawable.pic28,R.drawable.pic29,R.drawable.pic30}; // รวมรูป

    ImageViewAdapter iva;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.idRvImageList);                 // เชื่อม [ตัวแปร] Recycler View
        lm = new GridLayoutManager(this,2); // จำนวน คอลัม
        rv.setLayoutManager(lm);                               // set Layout

        iva = new ImageViewAdapter(images);                    // สร้าง Adapter
        rv.setAdapter(iva);                                    // เชื่อมกับ Recycler View
    }
}
