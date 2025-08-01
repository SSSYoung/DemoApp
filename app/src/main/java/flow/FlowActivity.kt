package flow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Lifecycle
import com.biubiu.eventbus.observe.observeEvent
import com.biubiu.eventbus.post.postEvent
import com.example.demoapp.R
import com.example.demoapp.databinding.ActivityFlowBinding
import com.example.flow.TestFragment
import com.example.flow.event.GlobalEvent
import flow.event.ActivityEvent
import kotlinx.coroutines.Dispatchers

class FlowActivity : AppCompatActivity() {
    companion object {
        val TAG = "FlowEventBus"
        val STICKY = "sticky"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val root = ActivityFlowBinding.inflate(layoutInflater)

        setContentView(root.root)

        observeGlobalEvents()
        observeActivityScopeEvents()

        supportFragmentManager.beginTransaction().replace(R.id.frame, TestFragment())
            .commitAllowingStateLoss()

        //发送一个activityEvent
        root.sendActivityEvent.setOnClickListener {
            postEvent(this, ActivityEvent("send by Activity"))
        }


        root.sendEvent.setOnClickListener {
            postEvent(GlobalEvent("send by Activity"))
        }

        root.openSec.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }

    }

    //跨页面
    private fun observeGlobalEvents() {
        //全局事件
        observeEvent<GlobalEvent> { value ->
            Log.d(TAG, "MainActivity received GlobalEvent  :${value.name}")
        }
    }


    //本页面
    private fun observeActivityScopeEvents() {
        //Activity 级别的 事件
        //自定义事件
        observeEvent<ActivityEvent>(this) {
            Log.d(TAG, "MainActivity received ActivityEvent: ${it.name}")
        }

//        //自定义事件 切换线程
        observeEvent<ActivityEvent>(Dispatchers.IO) {
            Log.d(TAG, "received ActivityEvent:${it.name} " + Thread.currentThread().name)
        }
//
//        //自定义事件 指定最小生命周期
        observeEvent<ActivityEvent>(minActiveState = Lifecycle.State.DESTROYED) {
            Log.d(TAG, "received ActivityEvent:${it.name}   >  DESTROYED")
        }

//        //自定义事件 切换线程 + 指定最小生命周期
//        observeEvent<ActivityEvent>(Dispatchers.IO, Lifecycle.State.DESTROYED) {
//            Log.d(
//                TAG,
//                "received ActivityEvent:${it.name} >  DESTROYED    " + Thread.currentThread().name
//            )
//        }

    }
}