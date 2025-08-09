package com.example.algo.test.Algo.lianbiao

import com.example.algo.test.Algo.lianbiao.Leetcode142.detectCycle

/**
 * @ProjectName: DemoApp
 * @Description:
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 不允许修改 链表。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 示例 2：
 *
 *
 *
 * 输入：head = [1,2], pos = 0
 * 输出：返回索引为 0 的链表节点
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * 示例 3：
 *
 *
 *
 * 输入：head = [1], pos = -1
 * 输出：返回 null
 * 解释：链表中没有环。
 *
 *
 * 提示：
 *
 * 链表中节点的数目范围在范围 [0, 104] 内
 * -105 <= Node.val <= 105
 * pos 的值为 -1 或者链表中的一个有效索引
 * @Author: uidq9989
 * @Date: 2025/8/7
 */
object Leetcode142 {
//    fun detectCycle(head: ListNode?): ListNode? {
//        if (head?.next == null) {
//            return null
//        }
//
//        //先得到环的长度
//        var slow = head
//        var fast = head.next
//        var count = 1
//        while (slow != null && fast != null && fast.next != null && slow != fast) {
//            slow = slow.next
//            fast = fast.next.next
//            count ++
//        }
//
//
//        if (count > 1) {
//            var tem = head
//
//            var tem1 = head
//            for (i in 0 until count) {
//                tem = tem!!.next
//            }
//
//            while (tem1 != tem) {
//                tem1 = tem1!!.next
//                tem = tem?.next
//            }
//
//            return tem
//        } else {
//            return null
//        }
//    }

    fun detectCycle(head: ListNode?): ListNode? {
        var slow = head
        var fast = head

        // 第 1 步：先判断是否存在环（Floyd 判圈）
        while (fast != null && fast.next != null) {
            slow = slow!!.next
            fast = fast.next!!.next
            if (slow == fast) {                 // 相遇，说明有环
                // 第 2 步：从相遇点和头节点同时出发，步长为 1，再次相遇即为入口
                var p1 = head
                var p2 = slow
                while (p1 != p2) {
                    p1 = p1!!.next
                    p2 = p2!!.next
                }
                return p1                       // 入环节点
            }
        }
        // fast 先到 null，说明无环
        return null
    }
}

fun main() {
    // 用例1：a1 -> a2 -> a3 -> a4 -> a5 -> a3 (环起点3)
    run {
        val a1 = ListNode(1)
        val a2 = ListNode(2)
        val a3 = ListNode(3)
        val a4 = ListNode(4)
        val a5 = ListNode(5)
        a1.next = a2
        a2.next = a3
        a3.next = a4
        a4.next = a5
        a5.next = a3

        val node = detectCycle(a1)
        println("用例1（尾指向中间）→ 环起点: ${node?.value ?: "null"}") // 3
    }

    // 用例2：b1 -> b2 -> b3 (无环)
    run {
        val b1 = ListNode(1)
        val b2 = ListNode(2)
        val b3 = ListNode(3)
        b1.next = b2
        b2.next = b3

        val node = detectCycle(b1)
        println("用例2（无环）→ 环起点: ${node?.value ?: "null"}") // null
    }

    // 用例3：c1 -> c2 -> c3 -> c1 (环起点是头)
    run {
        val c1 = ListNode(1)
        val c2 = ListNode(2)
        val c3 = ListNode(3)
        c1.next = c2
        c2.next = c3
        c3.next = c1

        val node = detectCycle(c1)
        println("用例3（头节点成环）→ 环起点: ${node?.value ?: "null"}") // 1
    }

    // 用例4：单节点自环
    run {
        val d1 = ListNode(7)
        d1.next = d1

        val node = detectCycle(d1)
        println("用例4（自环）→ 环起点: ${node?.value ?: "null"}") // 7
    }

    // 用例5：两个节点成环
    run {
        val e1 = ListNode(1)
        val e2 = ListNode(2)
        e1.next = e2
        e2.next = e1

        val node = detectCycle(e1)
        println("用例5（两节点成环）→ 环起点: ${node?.value ?: "null"}") // 1
    }

    // 用例6：f1 -> f2 -> f3 -> f4 -> f2
    run {
        val f1 = ListNode(1)
        val f2 = ListNode(2)
        val f3 = ListNode(3)
        val f4 = ListNode(4)
        f1.next = f2
        f2.next = f3
        f3.next = f4
        f4.next = f2

        val node = detectCycle(f1)
        println("用例6（环在中间）→ 环起点: ${node?.value ?: "null"}") // 2
    }

    // 用例7：空链表
    run {
        val node = detectCycle(null)
        println("用例7（空链表）→ 环起点: ${node?.value ?: "null"}") // null
    }
}