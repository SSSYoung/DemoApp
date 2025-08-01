package test

/**
 *
 * @ProjectName:  DemoApp
 * @Desc:
 * @Author:  YangShuang
 * @Date:  2024/1/5
 */
class Student1 {
    var name:String = "yang shuang"
        get() = field.uppercase()

    var age:Int = 18
        set(value) {
            if (age < 18) {
                age = -1
            }
        }
}

fun main() {
    val student1 = Student1()
    println(student1.name)
}