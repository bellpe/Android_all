package com.study.ex12_activitymove;

import android.app.Application;

//Application 클래스 : 앱이 실행되면 자동으로 생성(new)됨.
public class MyApplication extends Application {
    // 전역변수를 선언하는 곳
    // 접근 제한자 4개 : public private protected default
    // 정적변수 : 프로그램 시작시 특정번지에 할당되어 없어지지 않는 변수
    public static String user_id = "hong";
    public static String user_pw = "1234";
}
