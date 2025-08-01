package com.example.algo.test.Algo.haxi;

/**
 * 缺失的第一个正整数
 */
class BM53 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param nums int整型一维数组
     * @return int整型
     */
    public int minNumberDisappeared(int[] nums) {
        // write code here

        int length = nums.length;
        // 第一轮遍历，将小于等于0的数忽略（映射到n之外）
        for (int i = 0; i < length; i++) {
            if (nums[i] <= 0) {
                nums[i] = length + 1;
            }
        }
        // 第二轮遍历，做标记
        for (int i = 0; i < length; i++) {
            //只过滤小于n的数，标记对应位置的数为绝对值的负数。
            if (Math.abs(nums[i]) <= length) {
                nums[Math.abs(nums[i]) - 1] = -Math.abs(nums[Math.abs(nums[i]) - 1]);
            }
        }
        // 第三轮遍历，找到没被标记的位置
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return length + 1;
    }

    public static void main(String[] args) {

    }
}
