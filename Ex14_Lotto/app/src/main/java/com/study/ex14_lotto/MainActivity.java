package com.study.ex14_lotto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button[] btnArray1;
    Button[] btnArray2;
    Button[] btnArray3;
    Button[] btnArray4;
    Button[] btnArray5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnArray1 = new Button[6];
        btnArray2 = new Button[6];
        btnArray3 = new Button[6];
        btnArray4 = new Button[6];
        btnArray5 = new Button[6];

        //버튼 초기화
        for(int i = 0; i < btnArray1.length; i++){ //btn1~6
            int resID = getResources().getIdentifier("btn" + (i + 1)
                    , "id", getPackageName());
            btnArray1[i] = findViewById(resID);
        }
        for(int i = 0; i < btnArray2.length; i++){ //btn1~6
            int resID = getResources().getIdentifier("btn" + (i + 11)
                    , "id", getPackageName());
            btnArray2[i] = findViewById(resID);
        }
        for(int i = 0; i < btnArray3.length; i++){ //btn11~16
            int resID = getResources().getIdentifier("btn" + (i + 21)
                    , "id", getPackageName());
            btnArray3[i] = findViewById(resID);
        }
        for(int i = 0; i < btnArray4.length; i++){ //btn1~6
            int resID = getResources().getIdentifier("btn" + (i + 31)
                    , "id", getPackageName());
            btnArray4[i] = findViewById(resID);
        }
        for(int i = 0; i < btnArray5.length; i++){ //btn1~6
            int resID = getResources().getIdentifier("btn" + (i + 41)
                    , "id", getPackageName());
            btnArray5[i] = findViewById(resID);
        }

    }

    public void onButtonGenerate(View v) {

        //5번 랜덤수 발생
        Random random = new Random();
        int[] randomIntArray = new int[6];
        for(int i=0; i<6; i++) {
            int randomInt = random.nextInt(45) + 1;
            // 중복 추첨 방지
            randomIntArray[i] = randomInt;
            for (int j=0; j<=1; j++){
                if (randomIntArray[j]== randomInt){
                    i--; // 이전루프로 이동하고, 다시 추첨!
                    continue;
                }
            }
            btnArray1[i].setText( String.valueOf( randomInt ) );
        }
        for(int i=0; i<6; i++) {
            int randomInt = random.nextInt(45) + 1;
            btnArray2[i].setText( String.valueOf( randomInt ) );
        }
        for(int i=0; i<6; i++) {
            int randomInt = random.nextInt(45) + 1;
            btnArray3[i].setText( String.valueOf( randomInt ) );
        }
        for(int i=0; i<6; i++) {
            int randomInt = random.nextInt(45) + 1;
            btnArray4[i].setText( String.valueOf( randomInt ) );
        }
        for(int i=0; i<6; i++) {
            int randomInt = random.nextInt(45) + 1;
            btnArray5[i].setText( String.valueOf( randomInt ) );
        }
    }

}