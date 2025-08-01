package com.example.algo.test.Algo.huawei;

import java.util.Scanner;

class HJ1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println("{" + str + "}");
        char[] chars = str.toCharArray();
        int i;
        for (i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == ' ') {
                break;
            }
        }

        System.out.println(chars.length - 1 - i);
    }
}
