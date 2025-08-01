package mvvm

import android.app.Application
import android.util.Log
import com.example.demoapp.BuildConfig
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

abstract class BaseApplication : Application() {
    /**
     * onCreate is called before the first screen is shown to the user.
     *
     * Use it to setup any background tasks, running expensive setup operations in a background
     * thread to avoid delaying app start.
     */
    override fun onCreate(){
        super.onCreate()
        Log.e("BaseApplication", "onCreate")
    }

    val applicationScope = CoroutineScope(Dispatchers.Default)

}
