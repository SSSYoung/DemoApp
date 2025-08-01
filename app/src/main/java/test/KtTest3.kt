package test

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class KtTest3{
    var user:String = "yangshuang"
    var newUser:String by ::user
}

fun main() {


//    CreateDBAction(Mysql()).save()
//
//
//
//    val instance by lazy {
//
//    }
//
//    val coroutineScope = CoroutineScope(Dispatchers.Main)
//    coroutineScope.launch {
//
//    }
    //println("${KtTest3().newUser}")
    val sd by lazy {

    }
}

interface DB {
    fun save()
}

class Mysql : DB {
    override fun save() {
        println("Mysql")
    }
}

class CreateDBAction(db: DB) : DB by db