package offer;

import android.util.Log;

import java.util.logging.Logger;

class ThreadDemo {
    public static void main(String[] args) {
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                System.out.println("线程1");
            }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                try {
                    thread1.join();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("线程2");
                }
            }
        };

        Thread thread3 = new Thread() {
            @Override
            public void run() {
                try {
                    thread2.join();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("线程3");
                }
            }
        };

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
