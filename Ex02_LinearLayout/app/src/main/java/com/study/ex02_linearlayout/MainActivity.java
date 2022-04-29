package com.study.ex02_linearlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    // 오버로딩 : Overloading 메소드의 확장
    //          println(int a)
    //          println(String str)
    // 오버라이드 : 메소드 재정의
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 한 화면 : Activity Class 1개 + XML 1개
        // XML과 클래스를 연결!
        setContentView(R.layout.layout_exam3);
    }
}