package com.zonew.fivebutton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class twoActivity extends AppCompatActivity {
    EditText etMsgSend;
    TextView tvMsgReplyShow;
    String msgReply;
    public static final String LOG_TAG = twoActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        Log.d(LOG_TAG, "onCreate");

        etMsgSend = findViewById(R.id.idEtMsgSend);
        tvMsgReplyShow = findViewById(R.id.idTvValueback1Show);

        if (savedInstanceState != null) {
            if (savedInstanceState.getBoolean("REPLY") == true) {
                String str = savedInstanceState.getString("REPLY_TEXT");
                tvMsgReplyShow.setText(str);
                tvMsgReplyShow.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (tvMsgReplyShow.getVisibility() == View.VISIBLE) {
            outState.putBoolean("REPLY", true);
            outState.putString("REPLY_TEXT", tvMsgReplyShow.getText().toString());
        }
    }

    public void goPage2(View v) {
        Intent i = new Intent(this, two2Activity.class);
        String str = etMsgSend.getText().toString();
        i.putExtra("MSG_SEND", str);
        startActivityForResult(i, 1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                msgReply = data.getStringExtra("MSG_REPLY");
                tvMsgReplyShow.setText(msgReply);
            }
        }
    }
}