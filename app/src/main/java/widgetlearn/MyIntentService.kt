package widgetlearn

import android.app.IntentService
import android.content.Intent
import android.util.Log

class MyIntentService : IntentService("MyIntentService") {
    companion object {
        private const val TAG = "MyIntentService"
    }
    override fun onHandleIntent(intent: Intent?) {
        Log.d(TAG, "工作线程是: " + Thread.currentThread().name)
        val task = intent?.getStringExtra("task")
        Log.d(TAG, "任务是 :$task")
        try {
            Thread.sleep(2000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }

    override fun onStart(intent: Intent?, startId: Int) {
        val task = intent?.getStringExtra("task")
        Log.d(TAG, "onStart :$task")
        super.onStart(intent, startId)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val task = intent?.getStringExtra("task")
        Log.d(TAG, "onStartCommand :$task")
        return super.onStartCommand(intent, flags, startId)
    }
}