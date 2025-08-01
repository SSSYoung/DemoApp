package com.example.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class GsonTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gson_test);
        String json = "{\n" +
                "\t\"score\": 1,\n" +
                "\t\"domain\": \"call\",\n" +
                "\t\"intent\": \"call_number\",\n" +
                "\t\"state_code\": 5000,\n" +
                "\t\"tips\": \"好的，正在为您呼叫139139139139\",\n" +
                "\t\"tips_key\": \"call_number_key\",\n" +
                "\t\"content\": {\n" +
                "\t\t\"contact_num\": \"139139139139\"\n" +
                "\t}\n" +
                "}";
        DSEntity entity = GsonUtil.fromJson(json, DSEntity.class);
        String contactNum = entity.content.get("contact_num").getAsString();
        Log.d("yangshuang", "contactNum: " + contactNum);
    }
}