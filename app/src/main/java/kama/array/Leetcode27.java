package kama.array;

/**
 * @ProjectName: DemoApp
 * @Desc: 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并原地修改输入数组。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * @Author: YangShuang
 * @Date: 2024/4/15
 */
class Leetcode27 {
    public static int removeElement(int[] nums, int val) {
        int newlen = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[newlen] = nums[i];
                newlen++;
            }
        }

        return newlen;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int newLength = removeElement(nums, val);
        System.out.println("New Length: " + newLength);
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
