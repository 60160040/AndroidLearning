package com.zonew.fivebutton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class two2Activity extends AppCompatActivity {
    String msgSend;
    String msgReply;
    TextView tvMsgSendShow;
    EditText etMsgReply;
    public static final String LOG_TAG = two2Activity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two2);
        Log.d(LOG_TAG,"onCreate");

        tvMsgSendShow = findViewById(R.id.idTvValue2Show);
        etMsgReply = findViewById(R.id.idEtMsgReply);

        Intent i = getIntent();
        msgSend = i.getStringExtra("MSG_SEND");
        tvMsgSendShow.setText(msgSend);
    }
    public void goPage1(View v){
        Intent i = new Intent();
        msgReply = etMsgReply.getText().toString();
        i.putExtra("MSG_REPLY",msgReply);
        setResult(RESULT_OK,i);
        finish();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG,"onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG,"onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG,"onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG,"onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG,"onStop");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG,"onStart");
    }
}
