package com.example.algo.test.Algo.lianbiao;

/**
 * 删除给出链表中的重复元素（链表中元素从小到大有序），使链表中的所有元素都只出现一次
 */
class BM15 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public static ListNode deleteDuplicates(ListNode head) {
        // write code here
        if (head == null) {
            return head;
        }
        ListNode curHead = head;
        ListNode nextHead = head.next;

        while (curHead != null && nextHead != null) {
            if (curHead.val == nextHead.val) {
                //断开链表
                curHead.next = nextHead.next;
                nextHead = nextHead.next;
            } else {
                curHead = curHead.next;
                nextHead = curHead.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        int[] list1 = new int[]{1};
        ListNode listNode1 = ListNode.arrayToListNode(list1);

        ListNode.print(deleteDuplicates(listNode1));
    }
}
