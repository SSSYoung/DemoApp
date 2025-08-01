package com.example.algo.test.Algo.huawei;

import java.util.HashMap;
import java.util.Scanner;

class HJ8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();
        int size = scanner.nextInt();

        for (int i = 0; i < size; i++) {
            int key = scanner.nextInt();
            int value = scanner.nextInt();
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + value);
            } else {
                map.put(key, value);
            }
        }

        map.keySet().stream().sorted().forEach(key -> {
            System.out.println(key + " " + map.get(key));
        });
    }
}
