package interview.chapter1;

import android.util.SparseArray;

import java.util.HashMap;

class ThreadTest {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("run Thread1 start" + System.currentTimeMillis());
                    Thread.sleep(1000);
                    System.out.println("run Thread1 end" + System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    thread1.join();
                    System.out.println("run Thread2 start" + System.currentTimeMillis());
                    Thread.sleep(1000);
                    System.out.println("run Thread2 end" + System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thread2.join();
                    System.out.println("run Thread3 start" + System.currentTimeMillis());
                    Thread.sleep(1000);
                    System.out.println("run Thread3 end" + System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
