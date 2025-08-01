package com.example.demoapp.gpu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.demoapp.R;

public class GpuActivity extends AppCompatActivity {
    private WindowManager mWindowManager;
    private WindowManager.LayoutParams mLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpu);

        findViewById(R.id.btn_pop_window).setOnClickListener(v -> {
            //检查权限
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (!Settings.canDrawOverlays(this)) {
                    //启动Activity让用户授权
                    Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
                    startActivity(intent);
                    return;
                }
            }

            WindowUtils.showPopupWindow(this);
        });
    }
}