package com.study.ex11_activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //로그 출력 방법
        //System.out.println("로그 출력1"); //info레벨
        //Log.d("Main", "로그 출력2"); //debug레벨
        Log.d("Main", "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Main", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Main", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Main", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Main", "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Main", "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Main", "onDestroy");
    }

    public void onClickButton(View v){
        // 다른 화면(액티비티)로 이동
                              // 자신 액티비티객체, 이동할 액티비티 클래스
        Intent i = new Intent(this, SecondActivity.class);
        startActivity(i);
    }
}//MainActivity