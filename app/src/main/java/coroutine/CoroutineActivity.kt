package coroutine

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.Continuation
import kotlin.coroutines.CoroutineContext

/**
 *
 * @ProjectName:  DemoApp
 * @Desc:
 * @Author:  YangShuang
 * @Date:  2024/4/2
 */
@SuppressLint("LogNotTimber")
class CoroutineActivity : AppCompatActivity() {
//    val context = Dispatchers.IO + SupervisorJob()
//    private val ioScope = CoroutineScope(Dispatchers.IO + SupervisorJob())

//    suspend fun test() {
//        delay(1000)
//        println("test")
//    }
    suspend fun test1() {
        delay(1000)
        println("test1")
    }

    suspend fun test2() {
        delay(1000)
        println("test2")
    }

    suspend fun test3() {
        delay(1000)
        println("test3")
    }

    @SuppressLint("LogNotTimber")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
//            println("async start")
//            val b = async {
//                delay(2000)
//                "async"
//            }
//            b.await()
//            println("async end")
            test1()
            println("test1 end")
            test2()
            println("test2 end")
            test3()
            println("test3 end")
        }
//        lifecycleScope.launch {
//
//        }
//        GlobalScope.launch(Main) {
//            val dataDeferred  = requestDataAsync()
//            doSomeThingElse()
//            val data = dataDeferred.await()
//            processData(data)
//        }
//
//        Thread.sleep(1000)
//        doSomeThingElse2()
//        MainScope().launch {
//
//        }
//
//
//        GlobalScope.launch {
//            delay(3000)
//            Log.d(
//                "yangshuang",
//                "onCreate: 子线程"
//            )
//
//            withContext(Dispatchers.Main)  {
//                Log.d(
//                    "yangshuang",
//                    "onCreate: 主线程"
//                )
//            }
//        }
    }

//    private fun processData(data:String) {
//        Log.d(
//            "yangshuang",
//            "processData: $data"
//        )
//    }
//
//    private fun doSomeThingElse2() {
//        Log.d(
//            "yangshuang",
//            "doSomeThingElse2: "
//        )
//    }
}

//fun requestDataAsync():Deferred<String> {
//    return GlobalScope.async {
//        requestData()
//    }
//}
//
//suspend fun requestData():String {
//    delay(2000)
//    return "requestData 结果"
//}
//
//fun doSomeThingElse() {
//    Log.d(
//        "yangshuang",
//        "doSomeThingElse: "
//    )
//}