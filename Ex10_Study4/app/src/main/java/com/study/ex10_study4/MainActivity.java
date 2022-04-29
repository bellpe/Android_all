package com.study.ex10_study4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    //클래스의 멤버변수 : 클래스안에서 다 사용가능.
    Button[] btnArray;
    int[] numArray;
    TextView textView;
    int count = 1;

    TimerTask timerTask;
    Timer timer = new Timer();
    int time = 0; //단위 100ms단위

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //버튼클릭 리스너(익명 객체(클래스) 사용)
        //로컬변수 : 함수안에서만 사용후 사라짐.
//        Button btn1 = findViewById(R.id.btn1);
//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ((Button)view).setText("Click");
//            }
//        });



        textView = findViewById(R.id.textView);

        // 25개의 버튼을 일괄 초기화!!!
        //클래스객체 배열 25개 확보
        btnArray = new Button[25];

        for(int i = 0; i < btnArray.length; i++){
            int resID = getResources().getIdentifier("btn" + (i + 1)
                    , "id", getPackageName());
            btnArray[i] = findViewById(resID);
            btnArray[i].setVisibility(View.INVISIBLE);
        }

        numArray = new int[25];
    }

    public void onClickStart(View v) {
        count = 1; //Restart 초기화
        time = 0; // Restart 초기화

        startTimerTask();

        //셔플(섞는다) : 값을 교환 => index 0랑 index random(1~24)랑
        //정수 배열 : 1,2,3,4,....25
        for(int i=0; i<numArray.length; i++){
            numArray[i] = i+1; //1~25까지의 값이 초기화됨.
        }

        //치환 swap : a = b temp
        int temp = 0;
        Random random = new Random();
        for(int i = 0; i<1000; i++) {
            int randomIndex = random.nextInt(24) + 1;//1~24
            temp = numArray[0];
            numArray[0] = numArray[ randomIndex ];
            numArray[ randomIndex ] = temp;
        }

        for(int i = 0; i < btnArray.length; i++){
            btnArray[i].setVisibility(View.VISIBLE);
            btnArray[i].setText( String.valueOf( numArray[i] ) );

            btnArray[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String btnStr = ((Button)view).getText().toString();
                    //int(기본형) vs Integer(래퍼클래스: 확장(기본형보다 기능 많음))
                    //long vs Long
                    //byte vs Byte
                    Integer btnNum = Integer.valueOf( btnStr );
                    //int btnInt = Integer.parseInt( btnStr );
                    if( btnNum.intValue() == count ) {
                        //빙고!

                        ((Button)view).setVisibility(View.INVISIBLE);

                        //게임종료
                        if(count == 25) {
                            stopTimerTask();
                        }
                        count++;
                    }

                }
            });
        }
    }

    private void startTimerTask()
    {
        stopTimerTask();

        timerTask = new TimerTask()
        {
            @Override
            public void run()
            {
                time++;
                textView.post(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(time/10 + "." + time%10 + "초");
                    }
                });
            }
        };
        timer.schedule(timerTask,0 ,100);
    }

    private void stopTimerTask()
    {
        if(timerTask != null)
        {
            textView.setText( time/10 + "." + time%10 + "초" + " 게임종료!");
            timerTask.cancel();
            timerTask = null;
        }
    }

}//class