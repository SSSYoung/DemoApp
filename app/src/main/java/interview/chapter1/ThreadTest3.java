package interview.chapter1;

class ThreadTest3 {
    public static void main(String[] args) {
        ThreadLocal<Integer> integerThreadLocal = new ThreadLocal<>();


        integerThreadLocal.set(10);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                integerThreadLocal.set(15);
                System.out.println("子线程拿到的数据: " + integerThreadLocal.get());
            }
        });
        thread1.start();
    }
}
