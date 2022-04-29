package com.study.ex06_study2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
    }

    public void onClickButton(View v) {
        String numStr = textView.getText().toString();
        int numInt = Integer.valueOf( numStr );//문자열 => 정수
        if( v.getId() == R.id.buttonMinus ) {
            numInt--;
        }
        else if( v.getId() == R.id.buttonPlus){
            numInt++;
        }
        String numStr2 = String.valueOf( numInt ); //정수 => 문자열
        textView.setText( numStr2 );
    }
}