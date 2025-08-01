package com.example.algo.test.Algo.lianbiao;

public class BM1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param head ListNode类
     * @return ListNode类
     *
     * 使用栈的方式
     */
    // public ListNode ReverseList (ListNode head) {
    //     // write code here
    //     Stack<ListNode> stack = new Stack<>();
    //     while (head != null) {
    //         stack.push(head);
    //         head = head.next;
    //     }
    //
    //     if (stack.isEmpty()) {
    //         return null;
    //     }
    //
    //     ListNode resultHead = stack.pop();
    //     ListNode tmpHead = resultHead;
    //     while (!stack.isEmpty()) {
    //         ListNode pop = stack.pop();
    //
    //         tmpHead.next = pop;
    //         tmpHead = pop;
    //     }
    //
    //     tmpHead.next = null;
    //
    //     return resultHead;
    // }

    /**
     * 双链表求解是把原链表的结点一个个摘掉，每次摘掉的链表都让他成为新的链表的头结点，
     * 然后更新新链表。下面以链表1→2→3→4为例画个图来看下。
     * @param head
     * @return
     */
    public static ListNode ReverseList (ListNode head) {
        // write code here
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }

        return newHead;
    }

    public static void main(String[] args) {
        ListNode test = new ListNode(1);
        ListNode test2 = new ListNode(2);
        ListNode test3 = new ListNode(3);
        test.next = test2;
        test2.next = test3;

        ListNode.print(test);
        ListNode.print(ReverseList(test));
    }
}
