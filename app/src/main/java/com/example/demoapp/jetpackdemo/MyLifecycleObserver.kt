package com.example.demoapp.jetpackdemo

import android.util.Log
import androidx.lifecycle.*

//或者使用DefaultLifecycleObserver

class MyLifecycleObserver : LifecycleEventObserver {
    companion object {
        private const val TAG = "MyLifecycleObserver"
    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when (event) {
            Lifecycle.Event.ON_CREATE -> Log.e(TAG, "onStateChanged: ON_CREATE")
            Lifecycle.Event.ON_START -> Log.e(TAG, "onStateChanged: ON_START")
            Lifecycle.Event.ON_RESUME -> Log.e(TAG, "onStateChanged: ON_RESUME")
            Lifecycle.Event.ON_PAUSE -> Log.e(TAG, "onStateChanged: ON_PAUSE")
            Lifecycle.Event.ON_STOP -> Log.e(TAG, "onStateChanged: ON_STOP")
            Lifecycle.Event.ON_DESTROY -> Log.e(TAG, "onStateChanged: ON_DESTROY")
            else -> Log.e(TAG, "onStateChanged: else")
        }
    }

    /*
    inner class MyLifecycleObserver:DefaultLifecycleObserver {
        override fun onCreate(owner: LifecycleOwner) {
            super.onCreate(owner)
        }
    }
    */
}