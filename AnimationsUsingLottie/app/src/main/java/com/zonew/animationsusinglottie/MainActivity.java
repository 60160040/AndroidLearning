package com.zonew.animationsusinglottie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {
    boolean isCheckedDone = false;
    boolean isSwitchOn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Checked
        final LottieAnimationView lottieCheckedDone = findViewById(R.id.lottieCheckedDone);
        lottieCheckedDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int speed = 3;

                // on
                if (isCheckedDone) {
                    lottieCheckedDone.setSpeed(-speed); // reverse
                    lottieCheckedDone.playAnimation();
                    isCheckedDone = false;
                }
                // off
                else {
                    lottieCheckedDone.setSpeed(speed); // regular
                    lottieCheckedDone.playAnimation();
                    isCheckedDone = true;
                }
            }
        });

        // Switch button
        LottieAnimationView lottieSwitchButton = findViewById(R.id.lottieSwitchButton);
        lottieSwitchButton.setSpeed(3f);
        lottieSwitchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // on
                if (isSwitchOn) {
                    lottieSwitchButton.setMinAndMaxProgress(0.5f, 1.0f);
                    lottieSwitchButton.playAnimation();
                    isSwitchOn = false;
                }
                // off
                else {
                    lottieSwitchButton.setMinAndMaxProgress(0.0f, 0.5f);
                    lottieSwitchButton.playAnimation();
                    isSwitchOn = true;
                }
            }
        });
    }
}