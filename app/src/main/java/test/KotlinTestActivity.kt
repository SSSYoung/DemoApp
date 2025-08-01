package test

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import test.sealedtest.Result
import kotlin.coroutines.Continuation
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.coroutines.coroutineContext
import kotlin.coroutines.startCoroutine

class KotlinTestActivity: AppCompatActivity() {
    companion object {
        private const val TAG = "KotlinTestActivity"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //test()
        GlobalScope.launch {
            val kFunction2 = ::add
            test4(1, 2, kFunction2)
        }
    }

    private fun test4(x:Int,y:Int,block:(Int,Int)->Int) {
        block.invoke(x,y)
    }

    private fun add(x:Int,y:Int): Int {
        return x+y
    }

    private suspend fun test3() {
        val deferred = GlobalScope.async {
            Log.d(TAG, "test3: result before")
            delay(3000)
            Log.d(TAG, "test3: result after")
        }

        deferred.await()
    }

    private fun test() {
        GlobalScope.launch {
            Log.d(TAG, "place1: ${Thread.currentThread().name}")
            withContext(Dispatchers.Main) {
                Log.d(TAG, "place2: ${Thread.currentThread().name}")
            }
        }
    }

//    private fun test1() {
//        suspend {
//            // 协程体
//            Log.d(TAG, "CoroutineStart: +++++ ${coroutineContext[CoroutineName]}   ${Thread.currentThread().name}")
//            // val tmp = 1/0
//            "suspend 返回值"
//        }.startCoroutine(object : Continuation<String> {
//            override val context: CoroutineContext
//                get() = EmptyCoroutineContext + CoroutineName("修之竹") + CoroutineExceptionHandler { context, throwable ->
//                    Log.d(TAG, "CoroutineExceptionHandler: ++++ ${throwable}")
//                }
//
//            override fun resumeWith(result: Result<String>) {
//                // 协程执行完会执行 resumeWith 方法
//                Log.d(TAG, "resumeWith: ++++ CoroutineEnd")
//                result.onSuccess {
//                    Log.d(TAG, "++++++ resumeWith onSuccess: ${context[CoroutineName]?.name}")
//                }
//
//                result.onFailure {
//                    Log.d(TAG, "++++++ resumeWith onFailure")
//                    context[CoroutineExceptionHandler]?.handleException(context, it)
//                }
//            }
//        })
//    }

}