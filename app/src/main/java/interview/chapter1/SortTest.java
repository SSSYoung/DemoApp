package interview.chapter1;


import java.util.Arrays;

class SortTest {
    /**
     * 归并排序
     *
     * @param data
     * @param start
     * @param end
     */
    private static void mergeSort(int[] data, int start, int end) {
        int mid = (start + end) / 2;
        if (start < end) {
            mergeSort(data, start, mid);
            mergeSort(data, mid + 1, end);
            merge(data, start, mid, end);
        }
    }

    private static void merge(int[] data, int start, int mid, int end) {
        int l = start;
        int r = mid + 1;

        int[] tmp = new int[end - start + 1];
        int i = 0;
        while (l <= mid && r <= end) {
            if (data[l] < data[r]) {
                tmp[i++] = data[l++];
            } else {
                tmp[i++] = data[r++];
            }
        }

        while (l <= mid) {
            tmp[i++] = data[l++];
        }
        while (r <= end) {
            tmp[i++] = data[r++];
        }

        for (int j = start; j < end; j++) {
            data[j] = tmp[j - start];
        }
    }

    private static void quickSort(int[] data, int start, int end) {
        if (start < end) {
            int l, r, tmp;
            l = start;
            r = end;
            tmp = data[start];

            while (l < r) {
                //从右向左找
                while (l < r && data[r] >= tmp) {
                    r--;
                }

                if (l < r) {
                    data[l] = data[r];
                    l++;
                }

                while (l < r && data[l] <= tmp) {
                    l++;
                }

                if (l < r) {
                    data[r] = data[l];
                    r--;
                }
            }

            data[l] = tmp;

            quickSort(data, start, l);
            quickSort(data, l + 1, end);
        }
    }

    public static void main(String[] args) {
        // int[] test = {7, 3, 6, 9, 5};
        // quickSort(test, 0, test.length - 1);

        int[] test1 = {10, 50, 90, 30, 70};
        mergeSort(test1, 0, test1.length - 1);
        System.out.println(Arrays.toString(test1));
    }
}
