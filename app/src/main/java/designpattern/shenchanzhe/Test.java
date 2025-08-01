package designpattern.shenchanzhe;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

class Test {
   private static int MAX_VALUE = 40;
   // public static void main(String[] args) {
   //
   //    Concurrentcomm con = new Concurrentcomm();
   //    Thread produceThread = new Thread(new Runnable() {
   //       @Override
   //       public void run() {
   //          for (int i = 0; i < MAX_VALUE; i++) {
   //             try {
   //                Random random = new Random();
   //                Thread.sleep(random.nextInt(5));
   //                con.produce();
   //             } catch (InterruptedException e) {
   //                e.printStackTrace();
   //             }
   //          }
   //       }
   //    });
   //
   //    Thread cosumerThread = new Thread(new Runnable() {
   //       @Override
   //       public void run() {
   //          for (int i = 0; i < MAX_VALUE; i++) {
   //             try {
   //                Random random = new Random();
   //                Thread.sleep(random.nextInt(10));
   //                con.customer();
   //             } catch (InterruptedException e) {
   //                e.printStackTrace();
   //             }
   //          }
   //       }
   //    });
   //
   //    produceThread.start();
   //    cosumerThread.start();
   // }

   public static void main(String[] args) {

      ConcurrentcommReentrantLock con = new ConcurrentcommReentrantLock();
      Thread produceThread = new Thread(new Runnable() {
         @Override
         public void run() {
            for (int i = 0; i < MAX_VALUE; i++) {
               try {
                  Random random = new Random();
                  Thread.sleep(random.nextInt(5));
                  con.produce();
               } catch (InterruptedException e) {
                  e.printStackTrace();
               }
            }
         }
      });

      Thread cosumerThread = new Thread(new Runnable() {
         @Override
         public void run() {
            for (int i = 0; i < MAX_VALUE; i++) {
               try {
                  Random random = new Random();
                  Thread.sleep(random.nextInt(10));
                  con.customer();
               } catch (InterruptedException e) {
                  e.printStackTrace();
               }
            }
         }
      });

      produceThread.start();
      cosumerThread.start();
   }
}
