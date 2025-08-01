package mvvm.player

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import mvvm.lifecycle.IlifeCycle
import mvvm.lifecycle.LifeCyclerProvider
import mvvm.lifecycle.LifeState

open class BaseActivity : AppCompatActivity() {
    val lifeCycleProvider by lazy {
        LifeCyclerProvider()
    }

    private val lifeCycleListeners = arrayListOf<IlifeCycle>()

    fun addLifeCycleListen(listener: IlifeCycle) {
        if (!lifeCycleListeners.contains(listener)) {
            lifeCycleListeners.add(listener)
        }
    }

    fun removeLifeCycleListen(listener: IlifeCycle) {
        lifeCycleListeners.remove(listener)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        lifeCycleListeners.forEach {
//            it.onCreate()
//        }
        lifeCycleProvider.makeLifeState(LifeState.CREATE)
    }

    override fun onStart() {
        super.onStart()

        lifeCycleListeners.forEach {
            it.onStart()
        }
    }

    override fun onResume() {
        super.onResume()

        lifeCycleListeners.forEach {
            it.onResume()
        }
    }

    override fun onPause() {
        super.onPause()

        lifeCycleListeners.forEach {
            it.onPause()
        }
    }

    override fun onStop() {
        super.onStop()

        lifeCycleListeners.forEach {
            it.onStop()
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        lifeCycleListeners.forEach {
            it.onDestroy()
        }
    }
}