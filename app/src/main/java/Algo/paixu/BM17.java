package Algo.paixu;

/*输入：
        [-1,0,3,4,6,10,13,14],13
        复制
        返回值：
        6
        复制
        说明：
        13 出现在nums中并且下标为 6*/

class BM17 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param nums   int整型一维数组
     * @param target int整型
     * @return int整型
     */
    public static int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        // int[] test = new int[]{-1,0,3,4,6,10,13,14};
        // int target = 13;
        // System.out.println(search(test, target));

        int[] test = new int[]{9};
        int target = 8;
        System.out.println(search(test, target));
    }
}
