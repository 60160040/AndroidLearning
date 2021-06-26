package com.zonew.myprojactaffterupdate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText username, password;
    String trueUser, truePass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.idEtUsername);
        password = findViewById(R.id.idEtPassword);

        trueUser = "admin";
        truePass = "12345";

    }

    public void pageMain(View view) {
        String strUser = username.getText().toString();
        String strPass = password.getText().toString();

        // User&Pass correct
        if (strUser.equals(trueUser) && strPass.equals(truePass)) {
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
        }

        // User&Pass Invalid or TextUtils.isEmpty(strUser)
        else {
            Toast.makeText(this, "username " + strUser + " or password " + strPass + " Invalid", Toast.LENGTH_SHORT).show();
        }
    }
}