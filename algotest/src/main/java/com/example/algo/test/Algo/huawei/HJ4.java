package com.example.algo.test.Algo.huawei;

import java.util.Scanner;

class HJ4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = 0;
        while (sc.hasNext()) {
            String str = sc.nextLine().trim();
            int cur = str.length() - 1;

            for (int i = 0; i < str.length() - 2; i++) {
                double b = Math.pow(16, i);
                int a = getBase(str.charAt(cur));
                //System.out.println("a====" + a + ",b====" + b);
                result += ((int) (a * b));
                cur--;
            }

            System.out.println(result);
        }
    }

    private static int getBase(char c) {
        int rst = 0;
        if (c >= '0' && c <= '9') {
            rst = c - '0';
        } else if (c >= 'A' && c <= 'Z') {
            rst = c - 'A' + 10;
        } else if (c >= 'a' && c <= 'z') {
            rst = c - 'a' + 10;
        }
        return rst;
    }
}
