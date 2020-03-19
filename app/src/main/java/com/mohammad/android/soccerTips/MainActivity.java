package com.mohammad.android.soccerTips;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    ImageView bgApp, clover;
    Animation fromBottom;
    LinearLayout textSplash, textHome, menus;
    Button liveScoreButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        fromBottom = AnimationUtils.loadAnimation(this, R.anim.frombottom);
        bgApp = findViewById(R.id.bgapp);
        clover = findViewById(R.id.clover);
        textSplash = findViewById(R.id.textSplash);
        textHome = findViewById(R.id.textHome);
        menus = findViewById(R.id.menus);

        bgApp.animate().translationY(-1700).setDuration(800).setStartDelay(300);
        clover.animate().translationX(-2500).alpha(0).setDuration(800).setStartDelay(600);
        textSplash.animate().translationY(140).alpha(0).setDuration(800).setStartDelay(300);

        textHome.startAnimation(fromBottom);
        menus.startAnimation(fromBottom);
        liveScoreButton = findViewById(R.id.liveScoreButton);
        liveScoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LiveScore.class);
                startActivity(intent);
            }
        });

    }
}
