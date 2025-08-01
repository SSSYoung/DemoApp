package com.example.algo.test.Algo.shuangzhizheng;

import java.util.Arrays;

class BM87 {
    public static void main(String[] args) {
        int[] test1 = {4,5,6};
        int[] test2 = {1,2,3};
        merge(test1, test1.length, test2, test2.length);

        System.out.println(Arrays.toString(test1));
    }

    private static int[] getMerge(int A[], int m, int B[], int n) {
        int[] rst = new int[m + n];
        int i = 0;
        int j = 0;
        int index = 0;

        while (i < m && j < n) {
            if (A[i] < B[j]) {
                rst[index] = A[i];
                index++;
                i++;
            } else {
                rst[index] = B[j];
                index++;
                j++;
            }
        }

        if (i >= m) {
            while (j < n) {
                rst[index] = B[j];
                j++;
                index++;
            }
        } else {
            while (i < m) {
                rst[index] = A[i];
                i++;
                index++;
            }
        }

        return rst;
    }

    public static void merge(int A[], int m, int B[], int n) {
        int[] ints = getMerge(A, m, B, n);

        A = Arrays.copyOf(ints,m+n);
        System.out.println(Arrays.toString(A));
    }
}
