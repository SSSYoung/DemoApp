package com.example.algo.test.Algo.huawei;

import java.util.Scanner;

class HJ6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long num = scanner.nextLong();
        double sqrt = Math.sqrt(num);
        for (int i = 2; i <= sqrt; i++) {
            while (num % i == 0) {
                System.out.print(i + " ");
                num = num / i;
            }
        }

        if (num == 1) {
            System.out.println();
        } else {
            System.out.println(num);
        }
    }
}
