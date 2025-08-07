package com.example.algo.test.Algo.lianbiao;

class LeetCode203_1 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode cur = head;
        ListNode pre = dummyHead;
        while (cur != null) {
            if (cur.value == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }

        return dummyHead.next;
    }
}
