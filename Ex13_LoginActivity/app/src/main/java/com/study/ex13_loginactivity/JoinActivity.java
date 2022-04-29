package com.study.ex13_loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class JoinActivity extends AppCompatActivity {
    EditText editTextID;
    EditText editTextPW;
    EditText editTextName;
    EditText editTextPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
        editTextID = findViewById(R.id.editTextID);
        editTextPW = findViewById(R.id.editTextPW);
        editTextName = findViewById(R.id.editTextName);
        editTextPhone = findViewById(R.id.editTextPhone);

    }
    public void onButtonJoin(View v){
        String user_id = editTextID.getText().toString();
        String user_pw = editTextPW.getText().toString();
        String user_name = editTextName.getText().toString();
        String user_phone = editTextPhone.getText().toString();

        // 서버에 회원정보를 전송후 결과를 반환받음.
        // FAIL : 아이디가 중복됨.
        // OK : 회원정보를 저장하고 -> 로그인 화면으로 이동!

        // 전역변수에 저장
        MyApplication.user_id = user_id;
        MyApplication.user_pw = user_pw;
        MyApplication.user_name = user_name;
        MyApplication.user_phone = user_phone;

        // finish(); // 이전화면(약관)으로 이동??
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
        // 메인화면 -> 로그인화면 -> 약관동의(FLAG_ACTIVITY_NO_HISTORY) -> 화원가입 -> 로그인화면
        //FLAG_ACTIVITY_NO_HISTORY : 액티비티 매니저 스택에 쌓이지 않음.
    }
}