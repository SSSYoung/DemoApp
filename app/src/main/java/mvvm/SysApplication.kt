package mvvm

import android.annotation.SuppressLint
import android.content.Context
import android.content.IntentFilter
import android.os.Handler
import android.util.Log
import com.biubiu.eventbus.EventBusInitializer
import com.engine.clickwhatsee.ClickWhatSeeManager
import com.example.demoapp.accessibility.DebugBoardcastReceiver
import com.github.anrwatchdog.ANRError
import com.github.anrwatchdog.ANRWatchDog
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SysApplication : BaseApplication() {
    companion object {
        private const val TAG = "SysApplication"
        val handler = Handler()

        @SuppressLint("StaticFieldLeak")
        var context: Context? = null
    }
    private val receiver by lazy {
        DebugBoardcastReceiver()
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate:")
        context = applicationContext
        val anrWatchDog = ANRWatchDog()
        anrWatchDog.apply {
            setANRListener{ANRError->
                Log.d(TAG, "onCreate: ${ANRError.printStackTrace()}")
            }
        }

        registerReceiver(receiver,
            IntentFilter().also {
                it.addAction("com.example.demoapp.action.DEBUG")
            }
        )

        anrWatchDog.start()

        EventBusInitializer.init(this)
    }

    override fun onTerminate() {
        super.onTerminate()
        unregisterReceiver(receiver)
    }
}