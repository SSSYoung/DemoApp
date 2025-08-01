package com.example.algo.test.Algo.lianbiao;

class BM14 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public static ListNode oddEvenList(ListNode head) {
        // write code here
        if (head == null) {
            return null;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;
    }

    public static void main(String[] args) {
        int[] list1 = new int[]{1, 2, 3, 4, 5, 6};
        ListNode listNode1 = ListNode.arrayToListNode(list1);

        ListNode.print(oddEvenList(listNode1));
    }
}
