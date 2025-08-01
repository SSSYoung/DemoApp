package com.example.demoapp.accessibility

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.AccessibilityServiceInfo
import android.accessibilityservice.GestureDescription
import android.annotation.SuppressLint
import android.graphics.Path
import android.util.Log
import android.view.accessibility.AccessibilityEvent

@SuppressLint("LogNotTimber")
class MyAccessibilityService : AccessibilityService() {
    companion object {
        private const val TAG = "MyAccessibilityService"
        var myService: MyAccessibilityService? = null
        fun isStart(): Boolean {
            Log.d(TAG, "isStart: ${myService != null}")
            return myService != null
        }
    }

    fun performGesture(
        startX: Float,
        startY: Float,
        endX: Float,
        endY: Float,
        duration: Long,
        willContinue: Boolean,
        gestureResultCallback: GestureResultCallback = MyGestureResultCallback()
    ) {

        val path = Path()
        path.moveTo(
            startX,
            startY
        )
        path.lineTo(
            endX,
            endY
        )
        Log.d(
            TAG,
            "startX: $startX, startY: $startY, endX: $endX, endY: $endY, duration: $duration, willContinue: " +
                    "$willContinue"
        )
        val description = GestureDescription.Builder().addStroke(
            GestureDescription.StrokeDescription(
                path,
                0L,
                duration,
                willContinue
            )
        ).build()

        myService?.dispatchGesture(
            description,
            gestureResultCallback,
            null
        )
    }

    override fun onAccessibilityEvent(p0: AccessibilityEvent?) {
        Log.d(TAG, "onAccessibilityEvent: $p0")
    }

    override fun onInterrupt() {
        Log.d(TAG, "onInterrupt")
    }

    override fun onServiceConnected() {
        val serviceInfo = AccessibilityServiceInfo().apply {
            eventTypes = AccessibilityEvent.TYPES_ALL_MASK
            feedbackType = AccessibilityServiceInfo.FEEDBACK_GENERIC
            flags = AccessibilityServiceInfo.DEFAULT
            packageNames = arrayOf("com.tencent.mm") //监听的应用包名，支持多个
            notificationTimeout = 10
        }
        setServiceInfo(serviceInfo)

        myService = this
    }
}