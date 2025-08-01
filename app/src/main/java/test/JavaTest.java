package test;

import android.util.Log;

/**
 * 科大讯飞
 */
class JavaTest {
    // public static void main(String[] args) {
    //     // for (int i = 0; i < 10; i++) {
    //     //     Thread thread = new Thread(new Runnable() {
    //     //         @Override
    //     //         public void run() {
    //     //            int result = sum(2,3);
    //     //            System.out.println("Thread id: " + Thread.currentThread().getId() + ", result: " + result);
    //     //         }
    //     //     });
    //     //     thread.start();
    //     // }
    //
    //     String test;
    //     String[][] strings = new String[5][4];
    //
    //     System.out.println("length: " + strings.length);
    //
    //     // BanShenTest.test();
    //     // BanShenTest.getTAG();
    //     System.out.println("hello world");
    // }

    public static void main(String[] args) {
        String first = "First String";
        System.out.println("First initially = " + first);
        String second = first;
        System.out.println("String copy in second = " + second);
        first = "Updated string";
        System.out.println("First after update = " + first);
        System.out.println("second after update = " + second);
        String newCopy = String.copyValueOf(first.toCharArray());
        System.out.println("Copy using copyValueOf() = " + newCopy);

        String copyString = new String(first);
        System.out.println("Copy using new = " + copyString);
    }
}
