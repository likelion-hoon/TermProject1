package com.example.ljh.termproject1;


/**
 * 일정을 보여준다.
 * 편집/삭제 메뉴(또는 버튼)를 가지고 있다.
 * 편집 메뉴는 일정추가 편집 액티비티를 시작한다.
 * 삭제 메뉴는 일정을 삭제할지 확인(확인 받는 다이얼로그) 받고 삭제한다.
 * 일정 제목,날짜,시작/종료 시간, 장소, 메모를 보여준다.
 * 메모에는 텍스트, 멀티미디어(이미지, 오디오, 비디오) 데이터를 보여 준다.
 */

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ScheDetailsActivity extends Activity {

    // Month month;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedetail);

    /*
        // textview의 아이디를 얻어온다.(일정을 보여줄 위젯)
        TextView tv = (TextView) findViewById(R.id.date);
        // Switch Case문을 사용해서
        // 월별이면 아래 코드를 실행시키고
        tv.setText(month.MONTHS[i]);
        // 주별이면 아래 코드를 실행
        tv.setText(week.WEEKS[i]);
                                       */
    }
}
