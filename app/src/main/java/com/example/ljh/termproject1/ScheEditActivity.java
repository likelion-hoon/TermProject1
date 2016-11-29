package com.example.ljh.termproject1;

/**
 * 일정 추가/편집을 할 수 있는 UI를 보여준다.
 * 일정 제목, 날짜, 시작/종료 시간, 장소 메모를 편집할 수 있다.
 * 메모에는 텍스트, 멀티미디어(이미지,오디오,비디오) 데이터를 저장할 수 있다.
 */

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.database.SQLException;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static com.example.ljh.termproject1.R.styleable.View;

public class ScheEditActivity extends Activity {

    final static String TAG = "SQLITESCHE";

    private MyDBHelper helper;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheedit);

        helper = new MyDBHelper(this);

        // 입력된 값을 불러오기 위한 findViewById 6개
        final EditText mtitle = (EditText) findViewById(R.id.title);
        final EditText mdate = (EditText) findViewById(R.id.date);
        final EditText mstarttime = (EditText) findViewById(R.id.starttime);
        final EditText mendtime = (EditText) findViewById(R.id.endtime);
        final EditText mlocation = (EditText) findViewById(R.id.location);
        final EditText mmemo = (EditText) findViewById(R.id.memo);

        Button scheadd = (Button) findViewById(R.id.scheadd);
        scheadd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (!isExternalStorageWritable())
                    return;     // 외부메모리를 사용하지 못하면 끝냄
                requestPermission();

                try {
                    String sql = String.format(
                            // 테이블 칼럼 정의
                            "INSERT INTO schedule (title, date, starttime, endtime, location, memo)\n" +
                                    "VALUES (NULL, '%s', '%s', '%s', '%s', '%s')",
                            mtitle.getText(), mdate.getText(), mstarttime.getText(),
                            mendtime.getText(), mlocation.getText(), mmemo.getText());
                    helper.getWritableDatabase().execSQL(sql);
                    Toast.makeText(getApplicationContext(),"하나의 튜플 추가됨",Toast.LENGTH_SHORT);
                } catch (SQLException e) {
                    Log.e(TAG, "Error in inserting into DB");
                }
            }
        });
    }

    void requestPermission() {
        final int REQUEST_EXTERNAL_STORAGE = 1;
        String[] PERMISSIONS_STORAGE = {
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        };

        int permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    this,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }

        /* Checks if external storage is available for read and write */
        public boolean isExternalStorageWritable() {
            String state = Environment.getExternalStorageState();
            if (Environment.MEDIA_MOUNTED.equals(state)) {
                //result.setText("외부메모리 읽기 쓰기 모두 가능");
                return true;
            }
            return false;
        }

    /* Checks if external storage is available to at least read */
        public boolean isExternalStorageReadable() {
            String state = Environment.getExternalStorageState();
            if (Environment.MEDIA_MOUNTED.equals(state) ||
                    Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
                //result.setText("외부메모리 읽기만 가능");
                return true;
            }
            return false;
        }

        private String getDateTime() {
            SimpleDateFormat dateFormat = new SimpleDateFormat(
                    "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            Date date = new Date();
            return dateFormat.format(date);

        }
    }




