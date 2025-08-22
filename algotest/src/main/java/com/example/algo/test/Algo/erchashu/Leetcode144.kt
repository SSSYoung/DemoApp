package com.example.algo.test.Algo.erchashu

import java.util.Stack

/**
 * @ProjectName: DemoApp
 * @Description:
 * @Author: uidq9989
 * @Date: 2025/8/11
 */
object Leetcode144 {
    val result = arrayListOf<Int>()
    fun preorderTraversal(root: TreeNode?): List<Int> {
       if (root == null) {
            return result
       }

        // 统一迭代法
        val stack = Stack<Command>()

        stack.push(Command("go",root))
        while (stack.isNotEmpty()) {
            val pop = stack.pop()
            if (pop.type == "print") {
                result.add(pop.node.`val`)
            } else{
                pop.node.right?.let {
                    stack.push(Command("go", it))
                }

                pop.node.left?.let {
                    stack.push(Command("go", it))
                }

                pop.node.let {
                    stack.push(Command("print", it))
                }
            }
        }

        return result

        //普通迭代
//        if (root == null) {
//            return result
//        }
//
//        val stack = Stack<TreeNode>()
//
//        stack.push(root)
//
//        while (stack.isNotEmpty()) {
//            val pop = stack.pop()
//
//            result.add(pop.`val`)
//
//            if (pop.right != null) {
//                stack.push(pop.right)
//            }
//
//            if (pop.left != null) {
//                stack.push(pop.left)
//            }
//        }
        //递归
//        val cur = root
//
//        if (cur != null) {
//            result.add(cur.`val`)
//        }
//
//        if (cur?.left != null) {
//            preorderTraversal(cur.left)
//        }
//        if (cur?.right != null) {
//            preorderTraversal(cur.right)
//        }
//
//        return result
    }
}

fun main() {
    // 用例1：普通二叉树
    /*
        1
       / \
      2   3
     / \   \
    4   5   6
        前序：[1, 2, 4, 5, 3, 6]
     */
    runTestCase1()

    // 用例2：只有左子树
    /*
        1
       /
      2
     /
    3
        前序：[1, 2, 3]
     */
    runTestCase2()

    // 用例3：只有右子树
    /*
        1
         \
          2
           \
            3
        前序：[1, 2, 3]
     */
    runTestCase3()
}

fun runTestCase1() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left!!.left = TreeNode(4)
    root.left!!.right = TreeNode(5)
    root.right!!.right = TreeNode(6)

    Leetcode144.result.clear() // 清空全局结果
    val result = Leetcode144.preorderTraversal(root)
    println("用例1 - 前序遍历结果: $result")
}

fun runTestCase2() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.left!!.left = TreeNode(3)

    Leetcode144.result.clear()
    val result = Leetcode144.preorderTraversal(root)
    println("用例2 - 前序遍历结果: $result")
}

fun runTestCase3() {
    val root = TreeNode(1)
    root.right = TreeNode(2)
    root.right!!.right = TreeNode(3)

    Leetcode144.result.clear()
    val result = Leetcode144.preorderTraversal(root)
    println("用例3 - 前序遍历结果: $result")
}