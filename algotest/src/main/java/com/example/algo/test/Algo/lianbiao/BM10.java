package com.example.algo.test.Algo.lianbiao;

/**
 * 两个链表的第一个公共节点
 */
class BM10 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int length1 = getLength(pHead1);
        int length2 = getLength(pHead2);
        ListNode tmp1 = pHead1;
        ListNode tmp2 = pHead2;

        //强制A的长度最大
        if (length1 > length2) {
            int dif = length1 - length2;
            for (int i = 0; i < dif; i++) {
                tmp1 = tmp1.next;
            }

            while (tmp1 != tmp2) {
                tmp1 = tmp1.next;
                tmp2 = tmp2.next;
            }

            return tmp1;
        } else {
            int dif = length2 - length1;
            for (int i = 0; i < dif; i++) {
                tmp2 = tmp2.next;
            }

            while (tmp1 != tmp2) {
                tmp1 = tmp1.next;
                tmp2 = tmp2.next;
            }

            return tmp2;
        }
    }

    private int getLength(ListNode head) {
        ListNode cur = head;
        int i = 0;
        while (cur != null) {
            i++;
            cur = cur.next;
        }

        return i;
    }
}
