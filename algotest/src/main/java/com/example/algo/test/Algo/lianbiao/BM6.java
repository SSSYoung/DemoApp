package com.example.algo.test.Algo.lianbiao;

/**
 * 判断链表中是否有环
 */
class BM6 {
    //https://programmercarl.com/0142.%E7%8E%AF%E5%BD%A2%E9%93%BE%E8%A1%A8II.html#%E6%80%9D%E8%B7%AF
    //https://www.bilibili.com/video/BV1if4y1d7ob/?spm_id_from=333.880.my_history.page.click&vd_source=936cb4571c8bec390d49686ee31e5c3a
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while ((fast != null) && (fast.next != null)) {
            //快指针走两步
            fast = fast.next.next;
            //慢指针走一步
            slow = slow.next;

            //相遇了，说明有环
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while ((fast != null) && (fast.next != null)) {
            //快指针走两步
            fast = fast.next.next;
            //慢指针走一步
            slow = slow.next;

            //相遇了，说明有环
            if (slow == fast) {
                //从相遇点开始，每步一步一步跳，相交点就是环的入口
                ListNode node1 = head;
                ListNode node2 = slow;

                while (node1 != node2) {
                    node1 = node1.next;
                    node2 = node2.next;
                }

                return node1;
            }
        }

        return null;
    }
}
