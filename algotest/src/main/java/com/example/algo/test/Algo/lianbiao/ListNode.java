package com.example.algo.test.Algo.lianbiao;


public class ListNode {
    public int val;
    public ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void print(ListNode node) {
        StringBuilder stringBuilder = new StringBuilder();
        ListNode tmp = node;
        while (tmp != null) {
            stringBuilder.append(tmp.val).append(",");
            tmp = tmp.next;
        }

        System.out.println(stringBuilder.toString());
    }

    /**
     * 数组转化为单链表
     * @param array
     * @return
     */
    public static ListNode arrayToListNode(int[] array) {
        //int[] list = new int[]{1,2,3,4,5,6,7,8};

        ListNode cur = new ListNode(array[0]);
        ListNode head = cur;
        for (int index = 1; index < array.length; index++) {
            cur.next = new ListNode(array[index]);
            cur = cur.next;
        }

        return head;
    }

    public static void main(String[] args) {
        print(arrayToListNode(new int[]{1,2,3,4,5}));
    }
}
