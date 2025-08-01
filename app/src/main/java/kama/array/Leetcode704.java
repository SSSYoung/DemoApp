package kama.array;

/**
 * @ProjectName: DemoApp
 * @Desc: 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
 * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * @Author: YangShuang
 * @Date: 2024/4/15
 */
class Leetcode704 {
    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;


        //while (left <= right) 要使用 <= ，因为left == right是有意义的，所以使用 <=
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] > target) {
                //right 要赋值为 middle - 1，因为当前这个nums[middle]一定不是target
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] test = {1, 3, 5, 6, 7};
        System.out.println(search(test, 4));
    }
}
