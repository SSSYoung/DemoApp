package com.example.algo.test.Algo.lianbiao;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 单链表的排序
 * 1、遍历链表、放入数组
 * 2、排序
 * 依次遍历数组和链表，按照位置将链表中的节点值修改为排序后的数组值。
 */
class BM12 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类 the head node
     * @return ListNode类
     */
    public ListNode sortInList(ListNode head) {
        // write code here
        //step1:
        ArrayList<Integer> list = new ArrayList<>();
        ListNode tmp = head;
        while (tmp != null) {
            list.add(tmp.val);
            tmp = tmp.next;
        }

        //step2
        Collections.sort(list);
        ListNode tmp1 = head;
        while (tmp1 != null) {
            tmp1.val = list.remove(0);
            tmp1 = tmp1.next;
        }

        return head;
    }
}
