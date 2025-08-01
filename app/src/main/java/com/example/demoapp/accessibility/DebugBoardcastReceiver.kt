package com.example.demoapp.accessibility

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.engine.clickwhatsee.ClickWhatSeeManager

/**
 * adb shell am broadcast -a com.desaysv.jlr.vrcontrol.action.DEBUG -e cmd "app-SEARCH-真人秀" （$path-&command-$params）
 * adb shell am broadcast -a com.example.demoapp.action.DEBUG -e cmd "app-SEARCH-真人秀"
 */
class DebugBoardcastReceiver : BroadcastReceiver() {
    companion object {
        private const val TAG = "DebugBoardcastReceiver"
    }
    override fun onReceive(
        context: Context,
        intent: Intent
    ) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        val action = intent.action
        if (action != null && action == "com.example.demoapp.action.DEBUG") {
            // 在这里处理接收到的广播
            val extraData = intent.getStringExtra("cmd")

            Log.d(
                TAG,
                "Received broadcast with extra data: $extraData"
            )
            if (!extraData.isNullOrEmpty()) {
                val b = ClickWhatSeeManager.CanClickWhatSee(extraData)
                Log.d(
                    TAG,
                    "onReceive: result: $b"
                )
            }
        }
    }
}