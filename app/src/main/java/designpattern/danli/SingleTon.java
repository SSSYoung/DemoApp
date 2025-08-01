package designpattern.danli;

/**
 * 饿汉式单例模式
 *
 * 对应kotlin写法
 */
// class SingleTon {
//     // 1. 加载该类时，单例就会自动被创建
//     private static SingleTon instance = new SingleTon();
//
//     //构造函数 设置为 私有权限
//     private SingleTon(){
//
//     }
//
//     // 3. 通过调用静态方法获得创建的单例
//     public static SingleTon getInstance() {
//         return instance;
//     }
// }


/**
 * 懒汉式
 */
// class SingleTon {
//     // 1. 加载该类时，单例就会自动被创建
//     private static SingleTon instance = null;
//
//     //构造函数 设置为 私有权限
//     private SingleTon() {
//
//     }
//
//     // 3. 通过调用静态方法获得创建的单例
//     public synchronized SingleTon getInstance() {
//         if (instance == null) {
//             instance = new SingleTon();
//         }
//
//         return instance;
//     }
// }

/**
 * 双重检查的懒汉式
 */
class SingleTon {
    // 1. 加载该类时，单例就会自动被创建
    private static volatile SingleTon instance = null;

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

/**
 * Java 静态内部类的写法
 * 第一次加载Singleton类时并不会初始化sInstance，
 * 只有第一次调用getInstance方法时虚拟机加载SingletonHolder 并初始化sInstance ，
 * 这样不仅能确保线程安全也能保证Singleton类的唯一性，所以推荐使用静态内部类单例模式。
 */

// class SingleTon {
//     //构造函数 设置为 私有权限
//     private SingleTon(){
//
//     }
//
//     public static SingleTon getInstance() {
//         return SingletonHolder.mSingleTon;
//     }
//
//     private static class SingletonHolder {
//         private static final SingleTon mSingleTon = new SingleTon();
//     }
// }
