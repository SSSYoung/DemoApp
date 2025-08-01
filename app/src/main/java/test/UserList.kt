package test

/**
 *
 * kotlin by 委托模式学习
 *
 * 我就可以对接口进行功能扩展，而不需要关心接口的核心功能是怎么实现的。很自由很方便。
 * @ProjectName:  DemoApp
 * @Desc:
 * @Author:  YangShuang
 * @Date:  2024/1/3
 */
class UserList(private val list: List<User1>) : List<User1> by list {
    private val intance by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {

    }
    fun highRisk():List<User1> {
        return list.take(5)
    }

    fun sortByAge():List<User1> {
        return list.take(6)
    }
}