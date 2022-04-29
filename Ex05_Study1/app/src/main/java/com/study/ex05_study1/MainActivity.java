package com.study.ex05_study1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClickButton(View v) {
        ConstraintLayout layout = findViewById(R.id.layoutMain);
        if( v.getId() == R.id.buttonRed ) {
            layout.setBackgroundColor(Color.RED);
        }
        else if( v.getId() == R.id.buttonGreen ) {
            layout.setBackgroundColor(Color.GREEN);
        }
        else {
            layout.setBackgroundColor(Color.BLUE);
        }
    }
    public void onClickButtonRed(View v) {
        ConstraintLayout layout = findViewById(R.id.layoutMain);
        layout.setBackgroundColor(Color.RED);
    }
    public void onClickButtonGreen(View v) {
        ConstraintLayout layout = findViewById(R.id.layoutMain);
        layout.setBackgroundColor(Color.GREEN);
    }
    public void onClickButtonBlue(View v) {
        ConstraintLayout layout = findViewById(R.id.layoutMain);
        layout.setBackgroundColor(Color.BLUE);
    }
}