package widgetlearn

//最原始的构造方法
//class Person constructor(name: String, age: Int) {
//    private val name: String
//    private val age: Int
//    init {
//        this.name = name
//        this.age = age
//    }
//}

class Person(name: String) {
    constructor(name: String, age: Int) : this(name)

    constructor(name: String, age: Int, sex: String) : this(name, age)
}