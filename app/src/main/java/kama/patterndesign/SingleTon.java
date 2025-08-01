package kama.patterndesign;

/**
 * @ProjectName: DemoApp
 * @Desc:
 * @Author: YangShuang
 * @Date: 2024/5/13
 */
class SingleTon {
    private static volatile SingleTon mSingleTon;
    private SingleTon() {

    }

    //简单的同步方法（在整个方法上加synchronized关键字）可以确保线程安全，但这会造成性能问题。
    // 每次访问单例实例时，都需要进行同步，
    // 这会导致不必要的同步开销，特别是当实例已经创建后，每次获取实例仍然进行同步，会影响效率。
    public static SingleTon getInstance() {
        //双重检查锁定是一种既能保证线程安全又能提高执行效率的方法。通过在同步块外先检查实例是否已存在，
        // 只有在实例未被创建时才进行同步。这样，一旦实例被创建，
        // 后续的访问将不需要同步，从而减少了同步带来的性能影响。
        if (mSingleTon == null) {
            synchronized (SingleTon.class) {
                if (mSingleTon == null) {
                    mSingleTon = new SingleTon();
                }
            }
        }

        return mSingleTon;
    }
}
