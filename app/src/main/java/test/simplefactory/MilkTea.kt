package test.simplefactory

sealed class MilkTea {
    abstract var name: String?
    fun drink() {
        println("我喝的奶茶是$name")
    }
}

class PrimaryOdorMilkTea : MilkTea() {
    override var name: String?
        get() = "原味奶茶"
        set(value) {}
}

class BubbleMilkTea: MilkTea() {
    override var name: String?
        get() = "珍珠奶茶..."
        set(value) {}
}

class FruitMilkTea : MilkTea() {
    override var name: String?
        get() = "水果奶茶..."
        set(value) {}
}
