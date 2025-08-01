package Algo.lianbiao;

import android.graphics.Shader;
import android.widget.HeaderViewListAdapter;

class BM3 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     *  1,2,3,4,5,6,7,8  k =3
     * step1: 3.2.1  4.5.6.7.8
     *
     * step: 3.2.1. 6.5.4 7.8
     * @param head ListNode类
     * @param k    int整型
     * @return ListNode类
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        // write code here
        if ((head == null) || (head.next == null)) {
            return head;
        }

        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            if (tail == null) {
                return head;
            }

            tail = tail.next;
        }

        // 翻转前k个
        ListNode newHead = reverseList(head, tail);
        //翻转后，head就是最后一个了,连接
        head.next = reverseKGroup(tail, k);
        return newHead;
    }

    /**
     * 链表的反转，不是反转全部，只反转区间[head,tail)中间的节点，左闭右开区间
     *
     * 翻转后尾巴就是head了
     *
     * @param head
     * @param tail
     * @return
     */
    private static ListNode reverseList(ListNode head, ListNode tail) {

        ListNode pre = null;
        while (head != tail) {
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }

        return pre;
    }

    /**
     * 翻转整个链表
     *
     * @param head
     * @return
     */
    private static ListNode reverseList(ListNode head) {
        ListNode newHead = null;

        while (head != null) {
            ListNode tmp = head.next;
            head.next = newHead;
            newHead = head;
            head = tmp;
        }

        return newHead;
    }

    public static void main(String[] args) {
        int[] list = new int[]{1,2,3,4,5,6,7,8};

        ListNode cur = new ListNode(list[0]);
        ListNode head = cur;
        for (int index = 1; index < list.length; index++) {
            cur.next = new ListNode(list[index]);
            cur = cur.next;
        }

        ListNode.print(head);

        ListNode.print(reverseKGroup(head,3));
    }
}
