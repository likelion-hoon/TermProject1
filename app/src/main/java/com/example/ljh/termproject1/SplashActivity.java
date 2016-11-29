package com.example.ljh.termproject1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Created by B10601 on 2016-11-24.
 */

public class SplashActivity extends Activity {

    ImageView mSplash;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mSplash = (ImageView) findViewById(R.id.splash_image);
        Handler hd = new Handler();
        hd.postDelayed(new SplashHandler(), 5000); // 5초 후에 hd Handler 실행
    }

    private class SplashHandler implements Runnable {
        public void run() {
            startActivity(new Intent(getApplication(), MainActivity.class)); // 로딩이 끝나고 MainActivity로 이동
            SplashActivity.this.finish(); // 로딩페이지 Activity Stack에서 제거
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        startRocketTweenAnimation();
    }

    private void startRocketTweenAnimation() {
        Animation rocket_anim = AnimationUtils.loadAnimation(this, R.anim.splash);
        mSplash.startAnimation(rocket_anim);
    }
}
