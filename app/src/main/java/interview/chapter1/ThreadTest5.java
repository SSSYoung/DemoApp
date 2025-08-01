package interview.chapter1;


import java.util.ArrayList;
import java.util.Random;


class ThreadTest5 {
    private static final ArrayList<String> list = new ArrayList<>();
    private static final int MAX_SIZE = 20;
    private static int count = 0;

    static class Producer extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    Random random = new Random();
                    Thread.sleep(random.nextInt(350));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (list) {
                    while (list.size() == MAX_SIZE) {
                        try {
                            System.out.println("队列满了");
                            list.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    list.add("string: " + count);
                    System.out.println("生产的string: " + count + ",当前的size: " + list.size());
                    list.notifyAll();
                }
            }
        }
    }

    static class Consumer extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    Random random = new Random();
                    Thread.sleep(random.nextInt(400));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (list) {
                    while (list.size() == 0) {
                        try {
                            System.out.println("队列空了");
                            list.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    String remove = list.remove(0);
                    System.out.println("消费的string: " + remove + ",当前的size: " + list.size());
                    list.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {
        Producer producer = new Producer();
        Consumer consumer = new Consumer();
        producer.start();
        consumer.start();
    }
}
