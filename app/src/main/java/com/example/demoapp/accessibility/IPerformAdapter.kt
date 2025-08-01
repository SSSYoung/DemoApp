package com.example.demoapp.accessibility

/* Author:hxz
 * Time:2024/7/17 17:34
 */

abstract class IPerformAdapter {
    abstract fun performGesture(
        startX: Float,
        startY: Float,
        endX: Float,
        endY: Float,
        duration: Long
    )

    abstract fun performClick(
        x: Float,
        y: Float,
        time: Long
    )
}
