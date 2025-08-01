package com.example.algo.test.Algo.lianbiao;


class BM2 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 加一个虚拟节点
     * @param head ListNode类
     * @param m    int整型
     * @param n    int整型
     * @return ListNode类
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        //加一个虚拟节点   就不需要分情况讨论了
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode newHead = dummyNode;

        // write code here
        ListNode previous = getNode(newHead, m - 1);
        ListNode right = getNode(newHead, n);
        ListNode left = previous.next;
        ListNode next = right.next;
        // 切断链接
        previous.next = null;
        right.next = null;

        reverse(left);

        previous.next = right;

        left.next = next;
        return newHead.next;
    }

    private static ListNode getNode(ListNode head, int index) {
        ListNode rst = head;
        for (int i = 0; i < index; i++) {
            rst = rst.next;
        }

        return rst;
    }

    private static ListNode reverse(ListNode head) {
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
        int[] list = new int[]{1,3,5,7,9};

        ListNode cur = new ListNode(list[0]);
        ListNode head = cur;
        for (int index = 1; index < list.length; index++) {
            cur.next = new ListNode(list[index]);
            cur = cur.next;
        }

        ListNode.print(head);

        ListNode.print(reverseBetween(head,2,3));
    }
}
