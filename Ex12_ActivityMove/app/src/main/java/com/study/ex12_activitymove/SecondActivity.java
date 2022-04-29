package com.study.ex12_activitymove;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Log.d("SecondActivity", MyApplication.user_id);
        // 전역변수에 데이터 쓰기
        MyApplication.user_id = "park";

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String pw = intent.getStringExtra("pw");
        Log.d("Second", id);
        Log.d("Second", pw);
    }
    public void onClickNext(View v){
        Intent i = new Intent(this, ThirdActivity.class);
        // B 화면 -> C 화면으로 데이터 전달 후 반환값을 받고 싶다.
//        startActivity(i);
                               // 인텐트, 요청코드값
        startActivityForResult(i, 1000);
        // 가운데 줄은 deprecated 됨. 현재 버젼의 sdk에서 지원하지 않음.
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1000 && resultCode ==RESULT_OK){
            String returnData = data.getStringExtra("my_data");
            Log.d("Second","returnData:"+ returnData);
        }else {
            Log.d("Second", "데이터 없음");
        }
    }

    public void onClickBack(View v){

        finish();
    }
}