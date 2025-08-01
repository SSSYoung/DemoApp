package test

import kotlin.reflect.KProperty

/**
 *
 * @ProjectName:  DemoApp
 * @Desc: 自定义委托
 * @Author:  YangShuang
 * @Date:  2024/3/25
 */
class KtTest4 {
    private var str: String = "Default"

    operator fun getValue(
        owner: Owner,
        property: KProperty<*>,
    ): String {
        println("getValue 执行")
        return str
    }

    operator fun setValue(
        owner: Owner,
        property: KProperty<*>,
        s: String,
    ) {
        println("setValue 执行")
        str = s
    }
}

class Owner {
    var text: String by KtTest4()
}

fun main() {
    val owner = Owner()
    println(owner.text)
    owner.text = "yangshuang"
    println(owner.text)
}