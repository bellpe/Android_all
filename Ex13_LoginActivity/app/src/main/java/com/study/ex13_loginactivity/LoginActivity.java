package com.study.ex13_loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    EditText editTextID;
    EditText editTextPW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextID = findViewById(R.id.editTextID);
        editTextPW = findViewById(R.id.editTextPW);
    }
    public void onButtonLogin(View v){
        String user_id = editTextID.getText().toString();
        String user_pw = editTextPW.getText().toString();
        // 로그인 인증 절차
        // 1. 입력받은 id,pw를 서버에 전송
        // 2. 서버에서 OK/FAIL 정보를 반환받음.
        // 3. OK면, isLogin=true, id,pw 저장
        // 4. FAIL이면, 다시 로그인 하도록 알려줌.
        // 로그인 성공이면,
        MyApplication.isLogin = true;
        MyApplication.user_id = user_id;
        MyApplication.user_pw = user_pw;

        finish(); // => 현재 액티비티 종료하고 뒤로 돌아감
    }

    public void onButtonJoin(View v){
        Intent i = new Intent(this, AgreeActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY); // 액티비티 스택에 쌓이지 않음.
        startActivity(i);
    }
}