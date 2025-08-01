package Algo.huawei;

import java.util.Scanner;

class HJ2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input1 = scanner.nextLine().trim().toLowerCase();
        String input2 = scanner.nextLine().trim().toLowerCase();

        int length1 = input1.length();
        int length2 = input1.replace(input2, "").length();
        System.out.println(length1-length2);

        //System.out.println("{" + str + "}");

    }
}
