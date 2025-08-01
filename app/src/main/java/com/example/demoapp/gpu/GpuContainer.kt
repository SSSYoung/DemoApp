package com.example.demoapp.gpu

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.widget.LinearLayout
import androidx.lifecycle.*
import androidx.lifecycle.Observer
import java.util.*

class GpuContainer @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
) : LinearLayout(
    context,
    attrs
), LifecycleOwner, ViewModelStoreOwner {
    private val mLifecycleRegistry = LifecycleRegistry(this)
    private var mViewModelStore: ViewModelStore? = null

    companion object {
        private val TAG = "GpuContainer"
    }

    init {
        Log.i(
            TAG,
            "init: "
        )
        ViewModelProvider(this).get(GpuSettingViewModel::class.java).apply {
            val random = Random()
            setParams(
                random.nextInt(10),
                random.nextInt(20),
                random.nextInt(30),
                random.nextInt(40)
            )
            para1.observe(this@GpuContainer) {

            }
        }
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START)
        mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        //mLifecycleRegistry.markState()
        Log.i(
            TAG,
            "onAttachedToWindow: "
        )
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE)
        mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP)
        Log.i(
            TAG,
            "onDetachedFromWindow: "
        )
    }

    override val lifecycle: Lifecycle
        get() = mLifecycleRegistry
    override val viewModelStore: ViewModelStore
        get() {
            if (mViewModelStore == null) {
                mViewModelStore = ViewModelStore()
            }

            return mViewModelStore!!
        }
}