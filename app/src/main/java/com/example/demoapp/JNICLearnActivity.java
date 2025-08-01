package com.example.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.util.Log;

import java.util.Arrays;

public class JNICLearnActivity extends AppCompatActivity {

    private static final String TAG = "JNICLearnActivity";

    static {
        System.loadLibrary("demoapp");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Uri uri= ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        // String[] projection = {
        //         CallLog.Calls.NUMBER,
        //         CallLog.Calls.CACHED_NAME,
        //         CallLog.Calls.DATE,
        //         MAC_ADDR
        // };
        // String selection = MAC_ADDR + " = ?";
        // String[] selectionArgs = {"mac_addr"}; //mac address of focued device

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jniclearn);
        Log.d(TAG, "add rst====== " + add(20,5));
        Log.d(TAG, "sayHello====== " + sayHello("i am from java"));
        callStaticJavaMethod("helloworld");
        int[] test = {0, 1, 2, 3, 4, 5};
        Log.d(TAG, "increaseArrayInC====== " + Arrays.toString(increaseArrayInC(test)));
    }

    /**
     * 调用jni 两数相加 回调到java层方法
     * @param x
     * @param y
     * @return
     */
    public native int add(int x,int y);

    /**
     * 把java传来的string 拼接C string 后返回
     * @param jString
     * @return
     */
    public native String sayHello(String jString);

    public native void callStaticJavaMethod(String s);

    public native int[] increaseArrayInC(int[] array);
}