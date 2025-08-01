package com.example.algo.test.Algo.haxi;

import java.util.Arrays;
import java.util.HashMap;

class BM50 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param numbers int整型一维数组
     * @param target  int整型
     * @return int整型一维数组
     */
    public static int[] twoSum(int[] numbers, int target) {
        // write code here
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int index = 0; index < numbers.length; index++) {
            if (map.containsKey(target - numbers[index]) && (map.get(target - numbers[index]) != null)) {
                result[1] = index + 1;
                result[0] = map.get(target - numbers[index]) + 1;
            } else {
                map.put(numbers[index], index);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{3, 2, 4};
        int target = 6;
        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }
}
