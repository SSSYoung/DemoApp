package widgetlearn

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class MyReceiver : BroadcastReceiver() {
    companion object {
        private const val TAG = "MyReceiver"
    }
    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        val data = intent.getStringExtra("key")
        Log.d(TAG, "onReceive: $data")
    }
}