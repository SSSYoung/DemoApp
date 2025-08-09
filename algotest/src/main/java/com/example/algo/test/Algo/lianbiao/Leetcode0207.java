package com.example.algo.test.Algo.lianbiao;

/**
 * @ProjectName: DemoApp
 * @Description: 测试 getIntersectionNode 方法的多个用例（含交点/无交点/空链表等情况）
 * @Author: uidq9989
 * @Date: 2025/8/7
 */
class Leetcode0207 {
    public static void main(String[] args) {
        // 用例1：有交点（中间交汇）
        // A: 1 -> 2 -> 3 \
        //                 -> 8 -> 10
        // B:       5 -> 6 /
        {
            ListNode common = new ListNode(8);
            common.next = new ListNode(10);

            ListNode headA = new ListNode(1);
            headA.next = new ListNode(2);
            headA.next.next = new ListNode(3);
            headA.next.next.next = common;

            ListNode headB = new ListNode(5);
            headB.next = new ListNode(6);
            headB.next.next = common;

            runTest(headA, headB, "用例1：中间交汇");
        }

        // 用例2：有交点（完全重合）
        // A: 8 -> 10
        // B: 8 -> 10
        {
            ListNode common = new ListNode(8);
            common.next = new ListNode(10);

            ListNode headA = common;
            ListNode headB = common;

            runTest(headA, headB, "用例2：完全重合");
        }

        // 用例3：有交点（尾部只有1个节点）
        // A: 1 -> 2 -> 3 \
        //                 -> 4
        // B:       5 ----/
        {
            ListNode common = new ListNode(4);

            ListNode headA = new ListNode(1);
            headA.next = new ListNode(2);
            headA.next.next = new ListNode(3);
            headA.next.next.next = common;

            ListNode headB = new ListNode(5);
            headB.next = common;

            runTest(headA, headB, "用例3：尾部1节点交汇");
        }

        // 用例4：无交点（值相同但不同对象）
        // A: 1 -> 2 -> 3
        // B: 1 -> 2 -> 3
        {
            ListNode headA = new ListNode(1);
            headA.next = new ListNode(2);
            headA.next.next = new ListNode(3);

            ListNode headB = new ListNode(1);
            headB.next = new ListNode(2);
            headB.next.next = new ListNode(3);

            runTest(headA, headB, "用例4：无交点（值相同）");
        }

        // 用例5：一个链表为空
        // A: null
        // B: 1 -> 2
        {
            ListNode headA = null;

            ListNode headB = new ListNode(1);
            headB.next = new ListNode(2);

            runTest(headA, headB, "用例5：一个链表为空");
        }

        // 用例6：两个链表都为空
        // A: null
        // B: null
        {
            ListNode headA = null;
            ListNode headB = null;

            runTest(headA, headB, "用例6：两个链表都为空");
        }
    }

    public static void runTest(ListNode headA, ListNode headB, String caseName) {
        ListNode intersection = getIntersectionNode(headA, headB);
        System.out.print(caseName + " → ");
        if (intersection != null) {
            System.out.println("交点值: " + intersection.value);
        } else {
            System.out.println("无交点");
        }
    }

    // 原始实现方法（不改动逻辑）
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode cur1 = headA;
        ListNode cur2 = headB;

        ListNode newStart1 = headA;
        ListNode newStart2 = headB;
        while (cur1 != null && cur2 != null) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        int count = 0;
        if (cur1 == null) {
            while (cur2 != null) {
                count++;
                cur2 = cur2.next;
            }
            for (int i = 0; i < count; i++) {
                newStart2 = newStart2.next;
            }

            while (newStart1 != null && newStart2 != null) {
                if (newStart1 == newStart2) {
                    return newStart1;
                }
                newStart1 = newStart1.next;
                newStart2 = newStart2.next;
            }

            return null;

        } else {
            while (cur1 != null) {
                count++;
                cur1 = cur1.next;
            }

            for (int i = 0; i < count; i++) {
                newStart1 = newStart1.next;
            }

            while (newStart1 != null && newStart2 != null) {
                if (newStart1 == newStart2) {
                    return newStart1;
                }
                newStart1 = newStart1.next;
                newStart2 = newStart2.next;
            }

            return null;
        }
    }
}