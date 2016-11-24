package com.example.ljh.termproject1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * Created by B10601 on 2016-11-24.
 */

public class SplashActivity extends Activity {


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Handler hd = new Handler();
        hd.postDelayed(new splashhandler(), 3000); // 3초 후에 hd Handler 실행
    }

    private class splashhandler implements Runnable {
        public void run() {
            startActivity(new Intent(getApplication(), MainActivity.class)); // 로딩이 끝나고 MainActivity로 이동
            SplashActivity.this.finish(); // 로딩페이지 Activity Stack에서 제거
        }
    }
}
