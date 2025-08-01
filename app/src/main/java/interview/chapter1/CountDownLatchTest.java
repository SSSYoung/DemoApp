package interview.chapter1;

import java.util.concurrent.CountDownLatch;

class CountDownLatchTest {
    public static void main(String[] args) {
        CountDownLatch countDownLatch1 = new CountDownLatch(2);
        CountDownLatch countDownLatch2 = new CountDownLatch(1);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("run Thread1 start" + System.currentTimeMillis());
                    Thread.sleep(1000);
                    System.out.println("run Thread1 end" + System.currentTimeMillis());
                    countDownLatch1.countDown();
                    countDownLatch1.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    countDownLatch1.await();
                    System.out.println("run Thread2 start" + System.currentTimeMillis());
                    Thread.sleep(1000);
                    System.out.println("run Thread2 end" + System.currentTimeMillis());
                    countDownLatch2.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    countDownLatch2.await();
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
