package widgetlearn

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class MyReceiverDynamic : BroadcastReceiver() {
    companion object {
        private const val TAG = "MyReceiverDynamic"
        const val ACTION = "widgetlearn.MyReceiverDynamic"
    }
    override fun onReceive(context: Context?, intent: Intent?) {
        val data = intent?.getStringExtra("key")
        Log.d(TAG, "onReceive: data=$data")
    }
}