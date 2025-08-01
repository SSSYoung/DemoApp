package com.example.demoapp.jetpackdemo;

import android.util.Log;

class JniHelper {
    public int add(int x, int y) {
        Log.d("yangshuang", "JniHelper add x:" + x + ",y:" + y);
        return x + y;
    }

    //C中调用java的静态方法
    public static void sayHello(String str){
        Log.d("yangshuang",str);
    }
}
