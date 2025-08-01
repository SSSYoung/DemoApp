package com.example.demoapp.accessibility

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.GestureDescription
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.provider.Settings
import android.util.DisplayMetrics
import android.util.Log
import android.view.MotionEvent
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.demoapp.databinding.ActivityAccessibilityBinding
import android.graphics.Path
class AccessibilityActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAccessibilityBinding

    companion object {
        private const val TAG = "yangshuang"
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        Log.e(
            TAG,
            "dispatchTouchEvent: ${ev?.action}",

        )
        return super.dispatchTouchEvent(ev)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAccessibilityBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        ClickWhatSeeManager.initScriptEngineService(
//            applicationContext,
//            packageName
//        )
        initView()
    }

    @SuppressLint("LogNotTimber")
    private fun initView() {
        binding.start.setOnClickListener {
            val start = MyAccessibilityService.isStart()
            if (!start) {
                val intent = Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            } else {
                Log.e(
                    TAG,
                    "start success"
                )
            }

            Log.e(
                TAG,
                "initView: ${MyAccessibilityService.isStart()}"
            )
        }

        binding.tv1.setOnClickListener {
            Log.e(
                "yangshuang",
                "initView: ${(it as TextView).text}"
            )
        }
        binding.tv2.setOnClickListener {
            Log.e(
                "yangshuang",
                "initView: ${(it as TextView).text}"
            )

            val displayMetrics = DisplayMetrics()
            this.windowManager.defaultDisplay.getMetrics(displayMetrics)
            val screenWidth = displayMetrics.widthPixels
            val screenHeight = displayMetrics.heightPixels

            val startX = screenWidth / 2f
            val startY = screenHeight * 3 / 4f
            val endX = screenWidth / 2f
            val endY = screenHeight / 4f

            val steps = 30
            val durationPerStep = 100L  // 每次移动的持续时间，可以根据需要调整
            val yStep = (startY - endY) / steps

            for (i in 0 until steps) {
                val currentStartY = startY - i * yStep
                val currentEndY = currentStartY - yStep

                Handler().postDelayed(
                    {
                        MyAccessibilityService.myService?.performGesture(
                            startX,
                            currentStartY,
                            endX,
                            currentEndY,
                            durationPerStep,
                            i < steps - 1
                        )
                    },
                    i * durationPerStep
                )

            }
        }
        binding.tv3.setOnClickListener {
            // 创建一个手势路径，起点为 (100, 100)
            val path = Path().apply {
                moveTo(
                    620f,
                    1950f
                )
                lineTo(
                    620f,
                    1910f
                )
            }

            // 定义初始手势路径的持续时间和延迟时间
            val initialStartTime: Long = 0
            val initialDuration: Long = 50

            // 创建初始手势路径的描述
            val initialStroke = GestureDescription.StrokeDescription(
                path,
                initialStartTime,
                initialDuration,
                true
            )

            // 创建一个新的路径，继续上一个路径的终点
            val continuePath = Path().apply {
                moveTo(
                    620f,
                    1910f
                )
                lineTo(
                    620f,
                    1800f
                )
            }

            // 定义继续手势路径的持续时间和延迟时间
            val continueStartTime: Long = initialStartTime + initialDuration
            val continueDuration: Long = 500

            // 创建继续手势路径的描述
            val continueStroke = initialStroke.continueStroke(
                continuePath,
                continueStartTime,
                continueDuration,
                false
            )

            // 创建手势描述并添加手势路径
            val gestureBuilder = GestureDescription.Builder().apply {
                addStroke(initialStroke)
                addStroke(continueStroke)
            }

            // 构建最终的手势描述
            val gesture = gestureBuilder.build()

            // 使用 AccessibilityService 执行动作
            MyAccessibilityService.myService?.dispatchGesture(gesture,null,null)

//            val accessibilityService: AccessibilityService = // 获取你的 AccessibilityService 实例
//                accessibilityService.dispatchGesture(
//                    gesture,
//                    null,
//                    null
//                )
        }
        binding.tv4.setOnClickListener {
            performGestureStep(0)
        }
        binding.tv5.setOnClickListener {
            Log.e(
                "yangshuang",
                "initView: ${(it as TextView).text}"
            )
        }
    }

    fun performGestureStep(currentStep: Int) {
        val displayMetrics = DisplayMetrics()
        this.windowManager.defaultDisplay.getMetrics(displayMetrics)
        val screenWidth = displayMetrics.widthPixels
        val screenHeight = displayMetrics.heightPixels

        val startX = screenWidth / 2f
        val startY = screenHeight * 3 / 4f
        val endX = screenWidth / 2f
        val endY = screenHeight / 4f

        val steps = 30
        val durationPerStep = 30L  // 每次移动的持续时间，可以根据需要调整
        val yStep = (startY - endY) / steps

        if (currentStep >= steps) return

        val currentStartY = startY - currentStep * yStep
        val currentEndY = currentStartY - yStep

        MyAccessibilityService.myService?.performGesture(
            startX,
            currentStartY,
            endX,
            currentEndY,
            durationPerStep,
            currentStep < steps - 1,
            object : AccessibilityService.GestureResultCallback() {
                override fun onCompleted(gestureDescription: GestureDescription) {
                    super.onCompleted(gestureDescription)
                    Log.d(
                        TAG,
                        "onCompleted: currentStep: $currentStep"
                    )
                    performGestureStep(currentStep + 1)
                }

                override fun onCancelled(gestureDescription: GestureDescription?) {
                    super.onCancelled(gestureDescription)
                    // Handle gesture cancellation if needed
                }
            }
        )
    }
}