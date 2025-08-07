package com.example.algo.test.Algo.lianbiao;

class BM11 {
    /**
     * 三步
     * 1.翻转链表
     * 2.加法并记录进位（进位不等于0时还需要继续）
     * 3.再次翻转
     */

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head1 ListNode类
     * @param head2 ListNode类
     * @return ListNode类
     */
    public static ListNode addInList(ListNode head1, ListNode head2) {
        // write code here
        //翻转链表
        ListNode reverseHead1 = reverseList(head1);
        ListNode reverseHead2 = reverseList(head2);
        // System.out.println("Step1: ");
        // ListNode.print(reverseHead1);
        //ListNode.print(reverseHead2);
        ListNode tmp1 = reverseHead1;
        ListNode tmp2 = reverseHead2;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int carry = 0;
        //加法并记录进位
        ListNode rst = addList(tmp1, tmp2);
        // System.out.println("Step2: ");
        // ListNode.print(rst);
        //再次翻转
        return reverseList(rst);
    }

    private static ListNode addList(ListNode head1, ListNode head2) {
        ListNode tmp1 = head1;
        ListNode tmp2 = head2;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int carry = 0;
        //加法并记录进位
        //第三个
        while (tmp1 != null || tmp2 != null || carry != 0) {
            int value1 = 0;
            if (tmp1 != null) {
                value1 = tmp1.value;
            }

            int value2 = 0;
            if (tmp2 != null) {
                value2 = tmp2.value;
            }

            int rst = value1 + value2 + carry;
            cur.next = new ListNode(rst % 10);
            carry = rst / 10;
            cur = cur.next;
            if (tmp1 != null) {
                tmp1 = tmp1.next;
            }
            if (tmp2 != null) {
                tmp2 = tmp2.next;
            }
        }

        return dummy.next;
    }

    private static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;

            pre = cur;
            cur = next;
        }

        return pre;
    }

    public static void main(String[] args) {
        int[] list1 = new int[]{9, 3, 7};
        int[] list2 = new int[]{6, 3};
        ListNode listNode1 = ListNode.arrayToListNode(list1);
        ListNode listNode2 = ListNode.arrayToListNode(list2);
        addInList(listNode1, listNode2);
        // ListNode.print(addList(listNode1, listNode2));
        // ListNode.print(addInList(listNode1, listNode2));
    }
}
