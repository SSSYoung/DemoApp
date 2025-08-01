package com.example.algo.test.Algo.lianbiao;

import java.util.ArrayList;

/**
 * 合并 k 个升序的链表并将结果作为一个升序的链表返回其头节点。
 */
class BM5 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param lists ListNode类ArrayList
     * @return ListNode类
     */
    public static ListNode mergeKLists(ArrayList<ListNode> lists) {
        // write code here
        return mergeDivided(lists, 0, lists.size() - 1);
    }

    private static ListNode mergeDivided(ArrayList<ListNode> lists, int left, int right) {
        if (left == right) {
            return lists.get(left);
        } else if (left > right) {
            return null;
        } else {
            return mergeTwoList(mergeDivided(lists, left, (left + right) / 2),
                    mergeDivided(lists, (left + right) / 2 + 1, right));
        }
    }

    /**
     * 合并两个list
     * @param list1
     * @param list2
     * @return
     */
    private static ListNode mergeTwoList(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;
        while ((list1 != null) && (list2 != null)) {
            if (list1.val < list2.val) {
                dummy.next = list1;
                dummy = dummy.next;
                list1 = list1.next;
            } else {
                dummy.next = list2;
                dummy = dummy.next;
                list2 = list2.next;
            }
        }

        if (list1 != null) {
            dummy.next = list1;
        } else if (list2 != null) {
            dummy.next = list2;
        }

        return result.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = ListNode.arrayToListNode(new int[]{-1, 2, 4});
        ListNode listNode2 = ListNode.arrayToListNode(new int[]{1, 3, 4});
        ArrayList<ListNode> listNodes = new ArrayList<>();
        listNodes.add(listNode1);
        listNodes.add(listNode2);
        ListNode.print(mergeTwoList(listNode1,listNode2));
        ListNode.print(mergeKLists(listNodes));
    }
}
