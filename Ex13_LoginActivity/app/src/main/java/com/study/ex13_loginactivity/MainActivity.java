package com.study.ex13_loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textViewStatus; // null

    // onCreate()  : 액티비티 생성시 한 번만
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // XML과 Activity클래스를 연결!
        setContentView(R.layout.activity_main);

        textViewStatus =findViewById(R.id.textViewStatus);

    }
    // onResume() : 액티비티 화면이 다시 보일때마다 호출됨.
    @Override
    protected void onResume() {
        super.onResume();

        if(MyApplication.isLogin == true){
            textViewStatus.setText("로그인상태 : 로그인됨!");
        }else {
            textViewStatus.setText("로그인상태 : 로그오프상태!");
        }
    }


    public void onButtonLogin(View v){
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
    }
}