package kotlinlearn

import android.util.Log

class Person(val name: String) {
    companion object {
        private const val TAG = "Person"
    }

    init {
        System.out.println("init")
    }

    constructor(name: String, age: Int) : this(name) {
        System.out.println("age=========$age")
    }
}

fun main() {
    val arrayListOf = arrayListOf<String>()
    arrayListOf.asSequence()
    val person = Person("yangshuang", 12)
    System.out.println("${person.name}")
}