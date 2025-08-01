package com.example.algo.test.Algo.huawei;

import java.util.Scanner;

class HJ7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float f = scanner.nextFloat();
        float off = f - (int) f;
        int rst = 0;
        if (Float.compare(off, 0.5f) >= 0) {
            rst = (int) f + 1;
        } else {
            rst = (int) f;
        }
        System.out.println(rst);
    }
}
