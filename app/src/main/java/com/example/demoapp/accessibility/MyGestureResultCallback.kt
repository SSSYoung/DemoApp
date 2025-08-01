package com.example.demoapp.accessibility

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.GestureDescription

/**
 *
 * @ProjectName:  DemoApp
 * @Desc:
 * @Author:  YangShuang
 * @Date:  2024/7/24
 */
class MyGestureResultCallback : AccessibilityService.GestureResultCallback() {
    override fun onCancelled(gestureDescription: GestureDescription?) {
        super.onCancelled(gestureDescription)
    }

    override fun onCompleted(gestureDescription: GestureDescription?) {
        super.onCompleted(gestureDescription)
    }
}