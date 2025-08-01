package designpattern.danli


/**
 * 懒汉式的单例kotlin写法  双重检查线程安全的  对应java写法
 *
 *    class SingleTon {
// 1. 加载该类时，单例就会自动被创建
private static SingleTon instance = null;

//构造函数 设置为 私有权限
private SingleTon(){

}

// 3. 通过调用静态方法获得创建的单例
public synchronized SingleTon getInstance() {
if (instance == null) {
synchronized (SingleTon.class) {
if (instance == null) {
instance = new SingleTon();
}
}
}

return instance;
}
}
 *
 */
//class SingleTonKt private constructor() {
//    companion object {
//        val instance: SingleTonKt by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
//            SingleTonKt()
//        }
//    }
//}


//----------------------------
// kotlin 不带双重检查的单例写法
//class SingleTonKt private constructor() {
//    companion object {
//        private var instance: SingleTonKt? = null
//            get() {
//                if (field == null) {
//                    field = SingleTonKt()
//                }
//                return field
//            }
//
//        @Synchronized
//        fun get(): SingleTonKt? {
//            return instance
//        }
//    }
//}

/**
 * 静态内部类的写法
 */
class SingleTonKt private constructor() {
    companion object {
        fun getInstance() = Helper.instance
    }

    private object Helper{
        val instance = SingleTonKt()
    }
}

