package test.simplefactory

object SimpleFactoryDemo {
    fun makeMilkTea(name: String): MilkTea? {
        when (name) {
            "原味奶茶" ->
                return PrimaryOdorMilkTea();
            "珍珠奶茶" ->
                return BubbleMilkTea();
            "水果奶茶" ->
                return FruitMilkTea();
            else -> {
                println("对不起，我们店没有这种口味的奶茶！")
                return null
            }
        }
    }
}

