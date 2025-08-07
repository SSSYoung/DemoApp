package com.example.algo.test.Algo.lianbiao

import com.example.algo.test.Algo.lianbiao.LeetCode203.removeElements

/**
 * @ProjectName: DemoApp
 * @Description:
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * 示例 2：
 *
 * 输入：head = [], val = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 *
 *
 * @Author: uidq9989
 * @Date: 2025/8/6
 */
/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
object LeetCode203 {
    fun removeElements(head: ListNode?, target: Int): ListNode? {
        if (head == null) {
            return null
        }

        val vitual = ListNode(-1)
        vitual.next = head

        var cur = head

        var pre = vitual

        while (cur != null) {
            if (cur.value == target) {
                pre.next = cur.next
            } else {
                pre = pre.next
            }
            cur = cur.next
        }

        return vitual.next
    }
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

fun main() {
    val input = intArrayOf(1, 2, 6, 3, 4, 5, 6)
    val target = 2

    val head = arrayToListNode(input)
    println("Original list:")
    printList(head)

    val result = removeElements(head, target)
    println("After removing $target:")
    printList(result)
}