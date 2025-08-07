package com.example.algo.test.Algo.lianbiao

/**
 * @ProjectName: DemoApp
 * @Description:
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * 示例 2：
 *
 *
 * 输入：head = [1,2]
 * 输出：[2,1]
 * 示例 3：
 *
 * 输入：head = []
 * 输出：[]
 *
 *
 * 提示：
 *
 * 链表中节点的数目范围是 [0, 5000]
 * -5000 <= Node.val <= 5000
 *
 * @Author: uidq9989
 * @Date: 2025/8/6
 */
object Leetcode206 {
    fun reverseList(head: ListNode?): ListNode? {
        var pre:ListNode? = null
        var cur = head

        while (cur != null) {
            val nextTem = cur.next
            cur.next = pre
            pre = cur
            cur = nextTem
        }

        return pre
    }

    fun arrayToListNode(array: IntArray): ListNode? {
        if (array.isEmpty()) return null
        val head = ListNode(array[0])
        var current = head
        for (i in 1 until array.size) {
            current.next = ListNode(array[i])
            current = current.next
        }
        return head
    }

    fun printList(head: ListNode?) {
        var node = head
        while (node != null) {
            print("${node.value}")
            if (node.next != null) print(" -> ")
            node = node.next
        }
        println()
    }
}



fun main() {
    val input = intArrayOf(1, 2, 3, 4, 5)
    val head = arrayToListNode(input)

    println("Original list:")
    printList(head)

    val reversed = Leetcode206.reverseList(head)

    println("Reversed list:")
    printList(reversed)
}