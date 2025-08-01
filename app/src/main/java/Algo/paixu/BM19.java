package Algo.paixu;

class BM19 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param nums int整型一维数组
     * @return int整型
     */
    public static int findPeakElement (int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right)/2;
            if (nums[mid] > nums[mid + 1]) {
                // 右边是往下，不一定有坡峰
                right = mid;
            } else {
                // 右边是往上，一定能找到波峰
                left = mid + 1;
            }
        }

        return right;

        // write code here
    }

    public static void main(String[] args) {
        int[] test = new int[] {2,4,1,2,7,4,1};
        System.out.println(findPeakElement(test));
    }
}
