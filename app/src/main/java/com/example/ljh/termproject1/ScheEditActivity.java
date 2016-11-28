package com.example.ljh.termproject1;

/**
 * 일정 추가/편집을 할 수 있는 UI를 보여준다.
 * 일정 제목, 날짜, 시작/종료 시간, 장소 메모를 편집할 수 있다.
 * 메모에는 텍스트, 멀티미디어(이미지,오디오,비디오) 데이터를 저장할 수 있다.
 */

import android.app.Activity;
import android.database.SQLException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static com.example.ljh.termproject1.R.styleable.View;

/**
 * Created by B10601 on 2016-11-24.
 */

public class ScheEditActivity extends Activity {

    final static String TAG="SQLITEDBTEST";
    private MyDBHelper helper;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheedit);

        helper = new MyDBHelper(this);
        findViewById(R.id.add).setOnClickListener(mClickListener);
    }

    Button.OnClickListener mClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            // 선택한 날짜에 저장이 되어야 한다. SQLite 사용
            EditText title = (EditText)findViewById(R.id.title);
            try {
                String sql = String.format (
                        "INSERT INTO schedule (_id, title, datetime)\n"+
                                "VALUES (NULL, '%s', '%s')",
                        title.getText(), getDateTime());

                helper.getWritableDatabase().execSQL(sql);
            } catch (SQLException e) {
                Log.e(TAG,"Error in inserting into DB");
            }


        }
    };

    private String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);

    }


}
