package Algo.paixu;

import java.sql.Array;

class BM18 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param target int整型
     * @param array  int整型二维数组
     * @return bool布尔型
     * <p>
     * [
     * [1,2,8,9],
     * [2,4,9,12],
     * [4,7,10,13],
     * [6,8,11,15]
     * ]
     * <p>
     * 给定 target = 7，返回 true。
     * <p>
     * 给定 target = 3，返回 false。
     * 从左下角开始，此行最大，此列最小。
     */
    public static boolean Find(int target, int[][] array) {
        // write code here
        //从最后一行开始
        int row = array.length - 1;
        //从第一列开始
        int column = 0;

        /**
         * 第一行或者最后一列了
         */
        while (row >= 0 && column < array[0].length) {
            if (array[row][column] == target) {
                return true;
            } else if (array[row][column] > target) {
                // 太大了。换到上一行继续
                row--;
            } else if (array[row][column] < target) {
                column++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        //int[][] array = new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13}};
        int[][] array = new int[][]{{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println(Find(20, array));
    }
}
