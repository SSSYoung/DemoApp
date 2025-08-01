package test

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

object XiechengTest {

}

fun main() {
    GlobalScope.launch(context = Dispatchers.IO) {
        println("currentThread:${Thread.currentThread().name}, Hello world1")
        withContext(Dispatchers.Main) {
            println("currentThread:${Thread.currentThread().name}, Hello world2")
        }
    }
    //主动休眠两秒，防止 JVM 过快退出
    Thread.sleep(2000)
    println("end")
}

