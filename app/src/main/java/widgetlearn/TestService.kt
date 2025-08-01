package widgetlearn

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder

class TestService : Service() {
    inner class MyBinder : Binder() {
        fun getNum(): Int {
            return 1
        }
    }

    private val myBinder by lazy {
        MyBinder()
    }

    override fun onBind(intent: Intent?): IBinder {
        return myBinder
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun onUnbind(intent: Intent?): Boolean {
        return super.onUnbind(intent)
    }
}