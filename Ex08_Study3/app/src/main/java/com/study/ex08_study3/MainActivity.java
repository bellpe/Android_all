package com.study.ex08_study3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView textViewScore;
    ImageView imageView1;
    ImageView imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewScore = findViewById(R.id.textViewScore);
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
    }
    public void onClickButtonShake(View v) {
        //1.랜덤수 2개 발생
        Random random = new Random();
        int randomInt1 = random.nextInt(6) + 1;
        int randomInt2 = random.nextInt(6) + 1;

        //2. 이미지뷰 변경
        if( randomInt1 == 1) {
            imageView1.setImageResource(R.drawable.dice1);
        }
        else if( randomInt1 == 2) {
            imageView1.setImageResource(R.drawable.dice2);
        }
        else if( randomInt1 == 3) {
            imageView1.setImageResource(R.drawable.dice3);
        }
        else if( randomInt1 == 4) {
            imageView1.setImageResource(R.drawable.dice4);
        }
        else if( randomInt1 == 5) {
            imageView1.setImageResource(R.drawable.dice5);
        }
        else if( randomInt1 == 6) {
            imageView1.setImageResource(R.drawable.dice6);
        }

        if( randomInt2 == 1) {
            imageView2.setImageResource(R.drawable.dice1);
        }
        else if( randomInt2 == 2) {
            imageView2.setImageResource(R.drawable.dice2);
        }
        else if( randomInt2 == 3) {
            imageView2.setImageResource(R.drawable.dice3);
        }
        else if( randomInt2 == 4) {
            imageView2.setImageResource(R.drawable.dice4);
        }
        else if( randomInt2 == 5) {
            imageView2.setImageResource(R.drawable.dice5);
        }
        else if( randomInt2 == 6) {
            imageView2.setImageResource(R.drawable.dice6);
        }

        //3. 텍스트뷰 변경
        textViewScore.setText( randomInt1 + " : " + randomInt2);
    }
}