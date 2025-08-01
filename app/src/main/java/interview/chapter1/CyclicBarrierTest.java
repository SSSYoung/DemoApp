package interview.chapter1;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

class CyclicBarrierTest {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("发证件");
            }
        });

        TravelTask task1 = new TravelTask("张三", barrier);
        TravelTask task2 = new TravelTask("李四", barrier);
        TravelTask task3 = new TravelTask("王五", barrier);

        new Thread(task1).start();
        new Thread(task2).start();
        new Thread(task3).start();
    }

    private static class TravelTask implements Runnable {
        private String mName;
        private CyclicBarrier mCyclicBarrier;

        public TravelTask(String name, CyclicBarrier cyclicBarrier) {
            mName = name;
            mCyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println(mName + "到达目的地");
            try {
                mCyclicBarrier.await();
                //和countdownLatch的区别,await可以反复调用，可以汇总两次
                mCyclicBarrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(mName + "开始旅行");
        }
    }
}
