package com.study.ex12_activitymove;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Log.d("ThirdActivity", MyApplication.user_id );
    }
    public void onClickBack(View v){
        Intent i = new Intent();
        i.putExtra("my_data","답장입니다.");
        setResult(RESULT_OK, i);
        finish();
    }
}