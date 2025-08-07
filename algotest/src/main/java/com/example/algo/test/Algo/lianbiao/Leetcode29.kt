package com.example.algo.test.Algo.lianbiao

import com.example.algo.test.Algo.lianbiao.Leetcode29.removeNthFromEnd

/**
 * @ProjectName: DemoApp
 * @Description:
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 * @Author: uidq9989
 * @Date: 2025/8/6
 */
object Leetcode29 {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var count = 0
        var fast = head
        var dummy = ListNode(-1)
        dummy.next = head

        var pre = dummy
        while (count < n && fast != null) {
            fast = fast.next
            count++
        }

//        if (fast == null) {
//            return null
//        }

        var slow = head

        while (fast != null) {
            pre = pre.next
            slow = slow!!.next
            fast = fast.next
        }

        pre.next = slow!!.next

        return dummy.next
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
    val n = 5
    val head = arrayToListNode(input)

    println("Original list:")
    printList(head)

    val newHead = removeNthFromEnd(head, n)

    println("After removing $n-th node from end:")
    printList(newHead)
}



