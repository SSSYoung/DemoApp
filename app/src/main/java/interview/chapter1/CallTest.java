package interview.chapter1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class CallTest {
    public static void main(String[] args) {
        WorkCallable workCallable = new WorkCallable();
        FutureTask<Long> longFutureTask = new FutureTask<>(workCallable);
        new Thread(longFutureTask).start();

        long rst = 0;

        try {
            rst = longFutureTask.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("rst====" + rst);
    }


    static class WorkCallable implements Callable<Long> {
        @Override
        public Long call() {
            System.out.println("call");

            if (Thread.currentThread().isInterrupted()) {
                System.out.println("interrupt");
            }

            long sum = 0;
            for (int i = 0; i < 2000; i++) {
                sum += i;
            }
            return sum;
        }
    }


}
