package com.study.ex12_activitymove;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    // 액티비티간 데이터 전달
    // 1. A -> B 액티비티
    // 2. b-> A 값 반환
    // 3. 전역변수를 활용하는 방법(3개 이상의 화면에서 데이터 공유시)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Log 클래스 : 안드로이드 SDK에서 로그출력을 지원하는 클래스
        //       TAG : 로그 필터링 출력정보문자열
        Log.d("MainActivity", MyApplication.user_id);
        // static 변수는 클래스타입(이름) 뒤에 점을 찍어 접근
    }
    public void onClickNext(View v){
        Intent i = new Intent(this, SecondActivity.class);
        // 데이터 전달시 사용하는 함수
        // 오버로딩(매개변수를 다르게 함으로 함수의 기능을 확장하는 것)
        i.putExtra("id", "hong");
        i.putExtra("pw","1234");
        startActivity(i);
    }
}