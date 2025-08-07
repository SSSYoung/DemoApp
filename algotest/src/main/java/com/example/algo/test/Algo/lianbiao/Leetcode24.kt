package com.example.algo.test.Algo.lianbiao

/**
 * @ProjectName: DemoApp
 * @Description:给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 *
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1]
 * 输出：[1]
 *
 *
 * 提示：
 *
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 * @Author: uidq9989
 * @Date: 2025/8/6
 */
object Leetcode24 {
    fun swapPairs(head: ListNode?): ListNode? {

        var dummy = ListNode(-1)
        dummy.next = head
        var odd = head
        var even = head?.next

        var result = even ?: odd

        while (odd != null && even != null) {
            odd.next = even.next
            even.next = odd
            dummy.next = even

            dummy = odd
            odd = odd.next
            even = odd?.next
        }

        return result
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
    val input = intArrayOf(1, 2, 3, 4,6,7,8)
    val head = Leetcode24.arrayToListNode(input)

    println("Original list:")
    Leetcode24.printList(head)

    val swapped = Leetcode24.swapPairs(head)

    println("Swapped list:")
    Leetcode24.printList(swapped)
}