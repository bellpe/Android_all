package com.study.ex13_loginactivity;

import android.app.Application;

public class MyApplication extends Application {
    // 전역변수 선언!
    public static boolean isLogin = false; // 로그인 여부
    //public static String user_id; => null
    public static String user_id = ""; // => empty
    public static String user_pw = "";
    public static String user_name = "";
    public static String user_phone = "";

}
