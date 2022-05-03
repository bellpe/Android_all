package com.study.ex0502;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

// 이벤트 구현방법 2가지
// 1. 인터페이스 구현
// 2. 익명클래스 구현

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnWebView, btnCamera, btnDial, btnCall; // activity_main.xml의 객체를 멤버변수로 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // View 초기화
        btnWebView = findViewById(R.id.btnWebView);
        btnCamera = findViewById(R.id.btnCamera);
        btnDial = findViewById(R.id.btnDial);
        btnCall = findViewById(R.id.btnCall);

        // this의 의미 : View.OnClickListener를 구현한 MainActivity를 가리킴 -> onClick() 사용
        btnWebView.setOnClickListener(this);
        btnCamera.setOnClickListener(this);

        // 익명클래스 방식으로 이벤트 구현
        // : 독립적인 기능구현시 활용
        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent dialIntent = new Intent(
                        Intent.ACTION_DIAL,
                        Uri.parse("tel:01080209867")
                );
                startActivity(dialIntent);
            }
        });

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(
                        Intent.ACTION_CALL,
                        Uri.parse("tel:01080209867")
                );

                //액티비티에서 실행하는 경우 -> 권한 체크
                if ( ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) !=
                PackageManager.PERMISSION_GRANTED ) {

                    //권한 요청
                    ActivityCompat.requestPermissions(
                            MainActivity.this,
                            new String[]{Manifest.permission.CALL_PHONE},
                            0);
                    return; // 권한 요청 수락되면 여기서 끝나고 리턴됨.
                }
                startActivity(callIntent);
            }
        });

    }

    @Override
    public void onClick(View view) {

        // 버튼을 클릭했을 때 리소스ID를 변수에 저장
        int viewId = view.getId();

        if(viewId == R.id.btnWebView){
            // 암시적 인텐트 방식
            //: 액션 값을 활용해서 안드로이드에 설치된 기본 앱을 호출하는 방식
            Intent webviewIntent = new Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.naver.com")
            );
            startActivity(webviewIntent);
        }else if(viewId == R.id.btnCamera){
            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivity(cameraIntent);
        }


    }
}