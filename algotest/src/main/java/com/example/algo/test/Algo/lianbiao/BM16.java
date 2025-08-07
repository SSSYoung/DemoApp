package com.example.algo.test.Algo.lianbiao;

class BM16 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        // write code here
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode previous = dummy;
        ListNode cur = head;
        //ListNode next = head.next;

        while (cur != null && cur.next != null) {
            if (cur.value == cur.next.value) {
                while (cur != null && cur.next != null && cur.value == cur.next.value) {
                    cur = cur.next;
                }
                cur = cur.next;
                previous.next = cur;
            } else {
                previous = cur;
                cur = cur.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        int[] list1 = new int[]{1, 1};
        ListNode listNode1 = ListNode.arrayToListNode(list1);

        ListNode.print(deleteDuplicates(listNode1));
    }
}
