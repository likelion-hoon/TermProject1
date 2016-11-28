package com.example.ljh.termproject1;

/**
 * 액션 바를 가지고 있으며 월별,주별,일별 보기, 일정 추가 메뉴를 가지고 있다.
 * 월별, 주별, 일별 보기 메뉴에 따라 각각 월별,주별,일별 일정을 보여주는 프래그먼트를 보여준다.
 * 해당 보기 방식에 따라 액션 바의 타이틀을 적절히 바꾼다.
 *
 * 데이터 저장은 SQLite를 사용
 * 알림 기능을 추가 구현하면 +10점을 추가 부여한다.
 * 1인팀으로 할 경우 +20점을 추가 부여한다.
 */

/**
 * 데이터 저장은 SQLite를 사용
 * 알림 기능을 추가 구현하면 +10점을 추가 부여한다.
 * 1인팀으로 할 경우 +20점을 추가 부여한다.
 */
import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // 액션바 생성
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // 액션바 선택했을 때
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        android.support.v7.app.ActionBar ab = getSupportActionBar();

        switch (item.getItemId()) {
            case R.id.look_month: // 월별 보기 프래그먼트를 보여준다.
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new MonthFragment()).addToBackStack(null).commit();
                ab.setTitle("Month Calendar");
                return true;
            case R.id.look_week: // 주별 보기 프래그먼트를 보여준다.
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new WeekFragment()).addToBackStack(null).commit();
                ab.setTitle("Week Calendar");
                return true;
            case R.id.look_day: // 일별 보기 프래그먼트를 보여준다.
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new DayFragment()).addToBackStack(null).commit();
                ab.setTitle("Date Calendar");
                return true;
            case R.id.insert_sche:
                startActivity(new Intent(this, ScheDetailsActivity.class));

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

} // 메인액티비티 끝
