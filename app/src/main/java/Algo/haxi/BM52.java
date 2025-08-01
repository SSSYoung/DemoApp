package Algo.haxi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 数组中只出现一次的两个数字
 */
class BM52 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param nums int整型一维数组
     * @return int整型一维数组
     */
    public static int[] FindNumsAppearOnce(int[] array) {
        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        //遍历数组
        for(int i = 0; i < array.length; i++)
            //统计每个数出现的频率
            if(!mp.containsKey(array[i]))
                mp.put(array[i], 1);
            else
                mp.put(array[i], mp.get(array[i]) + 1);
        //再次遍历数组
        for(int i = 0; i < array.length; i++)
            //找到频率为1的两个数
            if(mp.get(array[i]) == 1)
                res.add(array[i]);
        //整理次序
        if(res.get(0) < res.get(1))
            return new int[] {res.get(0), res.get(1)};
        else
            return new int[] {res.get(1), res.get(0)};
    }

    public static void main(String[] args) {
        int[] test = {1, 4, 1, 6};
        FindNumsAppearOnce(test);
    }
}
