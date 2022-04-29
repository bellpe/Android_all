package com.study.ex07_imageview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    //안드로이드 이미지 파일 (꼭 소문자_숫자만 가능)
    // bmp : 무압축, 용량이 크다. 이미지처리시에 사용.
    // png : 무손실압축, 작은 이미지에 유리함.
    // jpg : 손실압축, 큰 이미지에 유리함.

    //저작권 무료 이미지 사이트 : 픽사베이
    ImageView imageView;
    Button buttonHide;
    //상태 변수(플래그 변수)
    boolean isHide = false;
    boolean isSecondImage = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        buttonHide = findViewById(R.id.buttonHide);
    }
    public void onClickButtonHide(View v) {
        if( isHide == false ) {
            imageView.setVisibility(View.INVISIBLE);
            isHide = true;
            buttonHide.setText("보이기");
        }else {
            imageView.setVisibility(View.VISIBLE);
            isHide = false;
            buttonHide.setText("숨기기");
        }
    }
    public void onClickButtonChangeImage(View v) {
        if( isSecondImage == false ){
            imageView.setImageResource(R.drawable.cafe2);
            isSecondImage = true;
        }else{
            imageView.setImageResource(R.drawable.cafe1);
            isSecondImage = false;
        }

    }
}
