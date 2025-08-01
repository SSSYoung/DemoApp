package kama.link

import Algo.lianbiao.ListNode


/**
 * @ProjectName: DemoApp
 * @Desc:
 * 题意：删除链表中等于给定值 val 的所有节点。
 *
 * 示例 1： 输入：head = [1,2,6,3,4,5,6], val = 6 输出：[1,2,3,4,5]
 *
 * 示例 2： 输入：head = [], val = 1 输出：[]
 *
 * 示例 3： 输入：head = [7,7,7,7], val = 7 输出：[]
 * @Author: YangShuang
 * @Date: 2024/4/25
 */
class Solution {
    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        val dummyNode = ListNode(-1) // 创建一个哑节点
        dummyNode.next = head        // 将哑节点指向头节点，以便处理头节点也可能被删除的情况
        var pre: ListNode? = dummyNode  // 前驱节点初始化为哑节点
        var cur = head                 // 当前节点初始化为头节点

        while (cur != null) {
            if (cur.`val` == `val`) {
                // 如果当前节点的值等于要删除的值，前驱节点的next指向当前节点的next，从而删除当前节点
                pre?.next = cur.next
            } else {
                // 只有当当前节点不需要被删除时，前驱节点才向前移动
                pre = pre?.next
            }
            cur = cur.next // 无论如何，当前节点都需要向前移动
        }

        return dummyNode.next // 返回哑节点的next，即新的头节点
    }
}