package kama.array;

/**
 * @ProjectName: DemoApp
 * @Desc: 给你一个按 非递减顺序 排序的整数数组 nums，
 * 返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * leetcode 977
 * <p>
 * <p>
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * @Author: YangShuang
 * @Date: 2024/4/15
 */
class Leetcode977 {
    public static int[] sortedSquares(int[] nums) {
        int head = 0;
        int tail = nums.length - 1;
        int[] newNums = new int[nums.length];
        int curIndex = newNums.length - 1;
        while (head <= tail) {
            if (Math.abs(nums[head]) > Math.abs(nums[tail])) {
                newNums[curIndex] = nums[head] * nums[head];
                curIndex--;
                head++;
            } else {
                newNums[curIndex] = nums[tail] * nums[tail];
                curIndex--;
                tail--;
            }
        }

        return newNums;
    }
}
