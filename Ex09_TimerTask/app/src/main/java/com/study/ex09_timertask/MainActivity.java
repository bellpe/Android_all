package com.study.ex09_timertask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    //TimerTask : 자바의 다중프로세스인 쓰레드 구현 클래스  => 백그라운드에서 주기적으로 처리할 때 사용
    TimerTask timerTask;
    //Timer : 타이머 구현 클래스
    Timer timer = new Timer();
    static int count = 0; //static 정적변수 : 프로그램생성시 특정메모리주소에 생성되고 변하지 않음.
    //dynamic 동적변수 : 수시로 생성 및 소멸됨.
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
    }

    public void onClickStart(View v) {
        startTimerTask();

    }
    public void onClickStop(View v) {
        stopTimerTask();
    }

    //접근제한자 - 변수,함수,클래스 앞에
    //public  : 모든 클래스에서 접근 가능
    //private : 내 클래스에서만 접근 가능
    //protected : 내 클래스 + 상속관계(자식)에서만 접근 가능
    //default(package) : protected + 같은 폴더(패키지)에서 접근 가능

    public void startTimerTask()
    {
        count = 0;

        stopTimerTask();

        //익명(이름없는) 객체(클래스) : 한번쓰고 버리는 객체(이름필요없음)
        timerTask = new TimerTask() {
            @Override
            public void run() {
                count++;
                textView.post(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(count + " 초");
                    }
                });
            }
        };

        //            타이머태스크  지연시간   간격시간
        timer.schedule(timerTask,0 ,1000);
    }

    public void stopTimerTask()
    {
        if(timerTask != null)
        {
            textView.setText( count + " 타이머태스크 종료됨.");
            timerTask.cancel();
            timerTask = null;
        }
    }

}