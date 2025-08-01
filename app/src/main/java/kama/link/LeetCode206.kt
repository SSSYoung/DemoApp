package kama.link

import Algo.lianbiao.ListNode

/**
 *
 * @ProjectName:  DemoApp
 * @Desc:给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * @Author:  YangShuang
 * @Date:  2024/4/26
 */
class LeetCode206 {
    //还可以用栈的特征来实现
    fun reverseList(head: ListNode?): ListNode? {
        if (head != null) {
            var cur = head
            var next = cur.next

            while (next != null) {
                val tem = next.next
                next.next = cur
                cur = next
                next = tem
            }

            head.next = null

            return cur
        }
        return null
    }
}