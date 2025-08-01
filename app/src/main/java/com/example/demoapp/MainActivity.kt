package com.example.demoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.View
import android.widget.Button
import anr.AnrDemoActivity
import camera2.Camera2Activity
import com.example.demoapp.accessibility.AccessibilityActivity
import com.example.demoapp.accessibility.DebugBoardcastReceiver
import com.example.demoapp.accessibility.MyAccessibilityService
import com.example.demoapp.compose.ComposeActivity
import com.example.demoapp.customview.CustomViewActivity
import com.example.demoapp.gpu.GpuActivity
import com.example.demoapp.hilt.HiltActivity
import com.example.demoapp.ipc.IpcActivity
import com.example.demoapp.jetpackdemo.*
import com.example.demoapp.soa.SoaActivity
import contact.ContactActivity
import coroutine.CoroutineActivity
import coroutine.CoroutineTestActivity
import flow.FlowActivity
import flow.SharedFlowActivity
import grpc.GRPCActivity
import mvvm.player.PlayerActivity
import network.NetWorkTestActivity
import network.OkHttpActivity
import test.KotlinTestActivity
import voice.VoiceIpcActivity
import widgetlearn.LifecyleTestActivity
import widgetlearn.WidgetTestActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onStart() {
        Log.d(
            TAG,
            "onStart: "
        )
        super.onStart()
    }

    override fun onResume() {
        Log.d(
            TAG,
            "onResume: "
        )
        super.onResume()
    }

    override fun onPause() {
        Log.d(
            TAG,
            "onPause: "
        )
        super.onPause()
    }

    override fun onStop() {
        Log.d(
            TAG,
            "onStop: "
        )
        super.onStop()
    }

    override fun onDestroy() {
        Log.d(
            TAG,
            "onDestroy: "
        )
        super.onDestroy()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(
            TAG,
            "onCreate: "
        )
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btn_hilt).setOnClickListener(this)
        findViewById<Button>(R.id.btn_voice_manager).setOnClickListener(this)
        findViewById<Button>(R.id.compose_learn).setOnClickListener(this)
        findViewById<Button>(R.id.button_wuzhangai).setOnClickListener(this)
        findViewById<Button>(R.id.button_soa).setOnClickListener(this)
        findViewById<Button>(R.id.button_0).setOnClickListener(this)
        findViewById<Button>(R.id.button_1).setOnClickListener(this)
        findViewById<Button>(R.id.button_2).setOnClickListener(this)
        findViewById<Button>(R.id.button_3).setOnClickListener(this)
        findViewById<Button>(R.id.button_4).setOnClickListener(this)
        findViewById<Button>(R.id.button_5).setOnClickListener(this)
        findViewById<Button>(R.id.button_6).setOnClickListener(this)
        findViewById<Button>(R.id.button_7).setOnClickListener(this)
        findViewById<Button>(R.id.button_8).setOnClickListener(this)
        findViewById<Button>(R.id.button_9).setOnClickListener(this)
        findViewById<Button>(R.id.button_10).setOnClickListener(this)
        findViewById<Button>(R.id.button_11).setOnClickListener(this)
        findViewById<Button>(R.id.button_12).setOnClickListener(this)
        findViewById<Button>(R.id.button_13).setOnClickListener(this)
        findViewById<Button>(R.id.button_14).setOnClickListener(this)
        findViewById<Button>(R.id.button_15).setOnClickListener(this)
        findViewById<Button>(R.id.button_16).setOnClickListener(this)
        findViewById<Button>(R.id.button_17).setOnClickListener(this)
        findViewById<Button>(R.id.button_18).setOnClickListener(this)
        findViewById<Button>(R.id.button_19).setOnClickListener(this)
        findViewById<Button>(R.id.button_20).setOnClickListener(this)
        findViewById<Button>(R.id.button_21).setOnClickListener(this)
        findViewById<Button>(R.id.button_22).setOnClickListener(this)
        findViewById<Button>(R.id.button_23).setOnClickListener(this)
        findViewById<Button>(R.id.button_24).setOnClickListener(this)
        findViewById<Button>(R.id.button_25).setOnClickListener(this)
        findViewById<Button>(R.id.button_26).setOnClickListener(this)
        findViewById<Button>(R.id.button_contact).setOnClickListener(this)
        findViewById<Button>(R.id.coroutineTest).setOnClickListener(this)
    }

    companion object {
        private const val TAG = "MainActivity"
    }

    private val receiver by lazy {
        DebugBoardcastReceiver()
    }

    override fun onClick(v: View?) {
        var intent: Intent
        when (v?.id) {
            R.id.btn_voice_manager -> {
                intent = Intent(
                    this,
                    VoiceIpcActivity().javaClass
                )
                startActivity(intent)
            }

            R.id.btn_hilt -> {
                intent = Intent(
                    this,
                    HiltActivity().javaClass
                )
                startActivity(intent)
            }

            R.id.compose_learn -> {
                intent = Intent(
                    this,
                    ComposeActivity().javaClass
                )
                startActivity(intent)
            }

            R.id.button_wuzhangai -> {
//                intent = Intent(this, AccessibilityActivity().javaClass)
//                startActivity(intent)
                intent = Intent(
                    this,
                    AccessibilityActivity().javaClass
                )
                startActivity(intent)
            }

            R.id.button_soa -> {
                intent = Intent(
                    this,
                    SoaActivity().javaClass
                )
                startActivity(intent)
            }

            R.id.button_0 -> {
                intent = Intent(
                    this,
                    PinyinActivity().javaClass
                )
                startActivity(intent)
            }

            R.id.button_1 -> {
                intent = Intent(
                    this,
                    TestActivity().javaClass
                )
                startActivity(intent)
            }

            R.id.button_2 -> {
                intent = Intent(
                    this,
                    LifeCycleActivity().javaClass
                )
                startActivity(intent)
            }

            R.id.button_3 -> {
                intent = Intent(
                    this,
                    LiveDataActivity().javaClass
                )
                startActivity(intent)
            }

            R.id.button_4 -> {
                intent = Intent(
                    this,
                    LiveDataForMapActivity().javaClass
                )
                startActivity(intent)
            }

            R.id.button_5 -> {
                intent = Intent(
                    this,
                    ViewModelDemoActivity().javaClass
                )
                startActivity(intent)
            }

            R.id.button_6 -> {
                intent = Intent(
                    this,
                    JniActivity().javaClass
                )
                startActivity(intent)
            }

            R.id.button_7 -> {
                intent = Intent(
                    this,
                    Camera2Activity().javaClass
                )
                startActivity(intent)
            }

            R.id.button_8 -> {
                intent = Intent(
                    this,
                    PlayerActivity().javaClass
                )
                startActivity(intent)
            }

            R.id.button_9 -> {
                intent = Intent(
                    this,
                    CustomViewActivity().javaClass
                )
                startActivity(intent)
            }

            R.id.button_10 -> {
                intent = Intent(
                    this,
                    JNICLearnActivity().javaClass
                )
                startActivity(intent)
            }

            R.id.button_11 -> {
                intent = Intent(
                    this,
                    GpuActivity().javaClass
                )
                startActivity(intent)
            }

            R.id.button_12 -> {
                intent = Intent(
                    this,
                    GpuActivity().javaClass
                )
                startActivity(intent)
            }

            R.id.button_13 -> {
                intent = Intent(
                    this,
                    WidgetTestActivity().javaClass
                )
                startActivity(intent)
            }

            R.id.button_14 -> {
                intent = Intent(
                    this,
                    LifecyleTestActivity().javaClass
                )
                startActivity(intent)
            }

            R.id.button_15 -> {
                intent = Intent(
                    this,
                    KotlinTestActivity().javaClass
                )
                startActivity(intent)
            }

            R.id.button_16 -> {
                intent = Intent(
                    this,
                    AnrDemoActivity().javaClass
                )
                startActivity(intent)
            }

            R.id.button_17 -> {
                intent = Intent(
                    this,
                    NetWorkTestActivity().javaClass
                )
                startActivity(intent)
            }

            R.id.button_18 -> {
                intent = Intent(
                    this,
                    OkHttpActivity().javaClass
                )
                startActivity(intent)
            }

            R.id.button_19 -> {
                if (!MyAccessibilityService.isStart()) {
                    try {
                        startActivity(Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS));
                    } catch (e: Exception) {
                        startActivity(Intent(Settings.ACTION_SETTINGS));
                        e.printStackTrace();
                    }
                }
            }

            R.id.button_20 -> {
                intent = Intent(
                    this,
                    FlowActivity().javaClass
                )
                startActivity(intent)
            }

            R.id.button_21 -> {
                intent = Intent(
                    this,
                    SharedFlowActivity().javaClass
                )
                startActivity(intent)
            }

            R.id.button_22 -> {
                intent = Intent(
                    this,
                    IpcActivity().javaClass
                )
                startActivity(intent)
            }

            R.id.button_23 -> {
                intent = Intent(
                    this,
                    GsonTestActivity().javaClass
                )
                startActivity(intent)
            }

            R.id.button_24 -> {
                intent = Intent(
                    this,
                    UnitTestActivity().javaClass
                )
            }

            R.id.button_26 -> {
                intent = Intent(
                    this,
                    WebSocketActivity().javaClass
                )
                startActivity(intent)
            }

            R.id.button_25 -> {
                intent = Intent(
                    this,
                    GRPCActivity().javaClass
                )
                startActivity(intent)
            }

            R.id.button_contact -> {
                intent = Intent(
                    this,
                    ContactActivity().javaClass
                )
                startActivity(intent)
            }

            R.id.coroutineTest -> {
//                intent = Intent(
//                    this,
//                    CoroutineActivity().javaClass
//                )
                intent = Intent(
                    this,
                    CoroutineTestActivity().javaClass
                )
                startActivity(intent)
            }
        }
    }
}