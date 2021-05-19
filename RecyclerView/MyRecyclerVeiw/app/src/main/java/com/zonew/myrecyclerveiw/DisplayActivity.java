package com.zonew.myrecyclerveiw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class DisplayActivity extends AppCompatActivity {
    ImageView ivImage;
    TextView tvNumberPhone;
    TextView tvFullName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        ivImage = findViewById(R.id.idIvImage);
        tvNumberPhone = findViewById(R.id.idTvNumberPhone);
        /*tvFullName = findViewById(R.id.idTvFullName);*/

        Intent i = getIntent();
        int id = i.getIntExtra("IMAGE_RES_ID",0); // เอา int จาก Intent

        ivImage.setImageResource(id);
        tvNumberPhone.setText("Image: "+id);      // show Text

    }
}
