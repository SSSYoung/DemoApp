package com.example.flow.event

import android.util.Log
import androidx.fragment.app.Fragment
import com.biubiu.eventbus.observe.observeEvent
import com.biubiu.eventbus.post.postEvent
import flow.event.ActivityEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class CustomComponent {
    fun sendEvent(fragment: Fragment) {
        postEvent(GlobalEvent("funny"))
        postEvent(fragment, GlobalEvent("funny"))
        postEvent(fragment.requireActivity(), GlobalEvent("funny"))
    }

    fun observer(fragment: Fragment) {
        observeEvent<GlobalEvent>(CoroutineScope(Dispatchers.Main)) {
            Log.d("yangshuang", "CustomComponent received GlobalEvent 3:${it.name}")
        }

        observeEvent<FragmentEvent>(fragment) {
            Log.d("yangshuang", "CustomComponent received FragmentEvent 3:${it.name}")
        }
        observeEvent<ActivityEvent>(fragment.requireActivity()) {
            Log.d("yangshuang", "CustomComponent received ActivityEvent 3:${it.name}")
        }
    }
}