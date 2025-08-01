package designpattern.shenchanzhe;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class ConcurrentcommReentrantLock {
    //常量  队列中的容量
    private static int MAX_VALUE = 10;
    //可以理解为缓存
    ArrayList<String> linkedList = new ArrayList<>();
    private volatile int produceIndex = 1;
    final ReentrantLock lock = new ReentrantLock();
    //定义两个条件，分别为“集合满”和“集合空”
    private Condition full = lock.newCondition();
    private Condition empty = lock.newCondition();

    //生产者方法
    public void produce() throws InterruptedException {
        lock.lock();
        try {
            while (linkedList.size() >= MAX_VALUE) {
                System.out.println("仓库已满，【生产者无法执行任务】");
                full.await();
            }

            //仓库没满
            linkedList.add(" ------ 我是任务" + produceIndex);
            System.out.println("【生产者】：生产了一个产品" + produceIndex + " \t【现仓储量为】:" + linkedList.size());
            produceIndex++;
            empty.signalAll();
        } catch (Exception e) {
        } finally {
            lock.unlock();
        }
    }

    public void customer() throws InterruptedException {
        lock.lock();
        try {
            while (linkedList.size() <= 0) {
                System.out.println("仓库无货，【消费者】： 暂时不能执行消费任务!");
                empty.await();
            }
            String info = linkedList.remove(0);
            System.out.println("【消费者】：消费了一个产品" + info + "\t【现仓储量为】:" + linkedList.size());
            full.signalAll();
        } catch (Exception e) {
        } finally {
            lock.unlock();
        }
    }
}
