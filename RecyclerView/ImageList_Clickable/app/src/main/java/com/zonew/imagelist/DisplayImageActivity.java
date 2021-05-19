package com.zonew.imagelist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class DisplayImageActivity extends AppCompatActivity {
    ImageView ivBigImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_image);

        ivBigImage = findViewById(R.id.idIvBigImage);

        Intent i = getIntent();                                      // รับ Intent มา
        int id = i.getIntExtra("IMAGE_RES_ID",0); // เอา int จาก Intent

        ivBigImage.setImageResource(id); // set Image
    }
}
 