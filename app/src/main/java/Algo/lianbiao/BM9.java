package Algo.lianbiao;

/**
 * 删除链表的倒数第n个节点
 */
class BM9 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode slow = dummyNode;
        ListNode fast = dummyNode;

        // 快指针先移动n步
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        // fast移动到null，slow指向的就是
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return dummyNode.next;
    }
}
