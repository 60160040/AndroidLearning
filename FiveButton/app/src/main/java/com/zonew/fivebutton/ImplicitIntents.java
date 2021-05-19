package com.zonew.fivebutton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class ImplicitIntents extends AppCompatActivity {
    EditText etWeb;
    EditText etMap;
    EditText etMsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intents);
        etWeb = findViewById(R.id.idEtWeb);
        etMap = findViewById(R.id.idEtLocation);
        etMsg = findViewById(R.id.idEtMsg);
    }
    public void openWeb(View v){
        String str = "https://" + etWeb.getText().toString();
        Uri web = Uri.parse(str);
        Intent i = new Intent(Intent.ACTION_VIEW,web);
        if(i.resolveActivity(getPackageManager()) != null)
            startActivity(i);
        else
            Log.d("ImplictIntents","Cannot handle this intent.");
    }
    public void openMap(View v){
        String str = etMap.getText().toString();
        Uri map = Uri.parse("geo:0,0?q=" + str);
        Intent i = new Intent(Intent.ACTION_VIEW,map);
        if(i.resolveActivity(getPackageManager()) != null)
            startActivity(i);
        else
            Log.d("ImplictIntents","Cannot handle this intent.");
    }
    public void shareMsg(View v){
        String str = etMsg.getText().toString();
        ShareCompat.IntentBuilder.from(this).setType("text/plain")
                .setChooserTitle("Choose app to share.").setText(str).startChooser();
    }
}
