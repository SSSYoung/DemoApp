package kama.array;

/**
 * @ProjectName: DemoApp
 * @Desc: leetcode 209
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
 * <p>
 * 示例：
 * <p>
 * 输入：s = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 提示：
 * <p>
 * 1 <= target <= 10^9
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^5
 * @Author: YangShuang
 * @Date: 2024/4/17
 */
class Leetcode209 {
    public static void main(String[] args) {
        int[] test = {2, 3, 1, 2, 1, 4, 3};
        System.out.println(minSubArrayLen(5, test));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int left = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            //// 只要当前和大于等于目标值就尝试缩小窗口
            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left];
                left++;//左窗口向右滑动
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
