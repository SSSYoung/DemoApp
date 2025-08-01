package test

/**
 *
 * @ProjectName:  DemoApp
 * @Desc:
 * @Author:  YangShuang
 * @Date:  2024/4/2
 */
class InoutTest {

    //把东西拿出来,out 生产者  只能get，不能add
    private val list1: MutableList<out Fruit> = ArrayList<Apple>()

    //把东西扔进去，in  消费者
    private val list2: MutableList<in Apple> = ArrayList<Fruit>()

//    fun test() {
//        list2.get
//    }
}

class MyStudentGet<out T>(_item: T) {
    private val item: T = _item
    fun get(): T = item
}
