package com.study.ex04_event;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // 각종 뷰를 정의함.
    TextView textView;
    EditText editText;

    // 액티비티가 생성될때, 딱 한번 수행되는 메소드
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 텍스트뷰의 인스턴스(객체)를 가져옴.
        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);
    }

    // 버튼 클릭 이벤트 메소드
    public void onClickButton(View v) {
        // logcat 창에 로그(기록) 남기기
        //        출력필터
        Log.d("MainActivity","버튼 클릭됨.");

        String inputStr = editText.getText().toString();

        textView.setText(inputStr);

        ConstraintLayout layout = findViewById(R.id.layoutMain);
        layout.setBackgroundColor(Color.GREEN);
    }
}