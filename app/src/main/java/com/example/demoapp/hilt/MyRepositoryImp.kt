package com.example.demoapp.hilt

import android.util.Log
import javax.inject.Inject

/**
 *
 * @ProjectName:  DemoApp
 * @Desc:
 * @Author:  YangShuang
 * @Date:  2024/7/26
 */
class MyRepositoryImp @Inject constructor() : MyRepository {
    override fun doSomething() {
        Log.d(
            "yangshuang",
            "doSomething: "
        )
    }
}