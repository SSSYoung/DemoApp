package Algo.haxi;

import java.util.HashMap;

class BM51 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param numbers int整型一维数组
     * @return int整型
     */
    public int MoreThanHalfNum_Solution(int[] numbers) {
        // write code here
       if (numbers.length == 1) {
          return numbers[0];
       }

        int threhold = (numbers.length + 1) / 2;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int value : numbers) {
            if (map.containsKey(value)) {
                int count = map.get(value) + 1;
                if (count >= threhold) {
                    return value;
                } else {
                    map.put(value, count);
                }
            } else {
                map.put(value, 1);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] test = {1, 2, 3, 2, 2, 2, 5, 4, 2};

    }
}
