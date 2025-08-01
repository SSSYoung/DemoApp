package com.example.algo.test.Algo.lianbiao;

class BM7 {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode slow = pHead;
        ListNode fast = pHead;

        while ((fast != null) && (fast.next != null)) {
            slow = slow.next;
            fast = fast.next.next;

            //相遇了
            if (slow == fast) {
                ListNode meetingNode = slow;
                //一个从head开始，一个从相遇点开始，每次一步步走，一定会相遇，相遇点就是环的入口
                ListNode node1 = pHead;
                ListNode node2 = meetingNode;
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
