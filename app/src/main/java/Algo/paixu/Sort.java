package Algo.paixu;

import java.util.ArrayList;
import java.util.Arrays;

class Sort {
    private static void quickSort1(int[] data, int start, int end) {
        if (start < end) {
            int l, r, tmp;
            l = start;
            r = end;
            tmp = data[l];
            while (l < r) {
                while (l < r && tmp < data[r]) {
                    r--;
                }

                if (l < r) {
                    data[l] = data[r];
                    l++;
                }

                while (l < r && tmp > data[l]) {
                    l++;
                }

                if (l < r) {
                    data[r] = data[l];
                    r--;
                }
            }

            data[l] = tmp;

            quickSort1(data, start, l);
            quickSort1(data, l + 1, end);
        }
    }

    private static void bubble(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    int tmp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = tmp;
                }
            }
        }
    }

    public static void sort(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    int tmp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = tmp;
                }
            }
        }
    }

    public static void quickSort(int[] a, int l, int r) {
        // if (l < r)
        // {
        //     int i,j,x;
        //
        //     i = l;
        //     j = r;
        //     x = a[i];
        //     while (i < j)
        //     {
        //         while(i < j && a[j] > x)
        //             j--; // 从右向左找第一个小于x的数
        //         if(i < j)
        //             a[i++] = a[j];
        //         while(i < j && a[i] < x)
        //             i++; // 从左向右找第一个大于x的数
        //         if(i < j)
        //             a[j--] = a[i];
        //     }
        //     a[i] = x;
        //     quickSort(a, l, i-1); /* 递归调用 */
        //     quickSort(a, i+1, r); /* 递归调用 */
        // }
        if (l < r) {
            int i, j, x;
            i = l;
            j = r;
            x = a[i];

            while (i < j) {
                //从右向左找到第一个小于x的数
                while (i < j && a[j] > x) {
                    j--;
                }

                if (i < j) {
                    a[i] = a[j];
                    i++;
                }

                //从左向右找到第一个大于x的数

                while (i < j && a[i] < x) {
                    i++;
                }

                if (i < j) {
                    a[j] = a[i];
                    j--;
                }
            }
            //设置基准值
            a[i] = x;
            quickSort(a, l, i - 1);
            quickSort(a, i + 1, r);
        }
    }

    private static int find(int[] test, int x) {
        if (test.length == 0) {
            return -1;
        }
        int left = 0;
        int right = test.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (test[mid] == x) {
                return mid;
            } else if (test[mid] > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        int[] test = {1, 3, 5, 7, 9};
        System.out.println(find(test, 2));
        //sort(test);
        bubble(test);
        System.out.println(Arrays.toString(test));

    }
}
