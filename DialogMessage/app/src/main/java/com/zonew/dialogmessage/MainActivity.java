package com.zonew.dialogmessage;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showDialog(View v) {
        AlertDialog.Builder adb = new AlertDialog.Builder(this);  // create AlertDialog Builder
        adb.setTitle("Alert Message");                                    // set Title
        adb.setMessage("Click OK to continue. Click cancel to stop.");    // set Message

        // create Positive button
        adb.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),"You pressed OK.",Toast.LENGTH_SHORT).show();
            }
        });

        // create Negative button
        adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),"You pressed Cancel.", Toast.LENGTH_SHORT).show();
            }
        });

        adb.show();
    }
}
