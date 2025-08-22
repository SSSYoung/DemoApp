package com.example.algo.test.Algo.erchashu

import java.util.Stack

/**
 * @ProjectName: DemoApp
 * @Description: 中序遍历 左 -> 中->右
 * @Author: uidq9989
 * @Date: 2025/8/12
 */
object LeetCode94 {
    val result = arrayListOf<Int>()
    fun inorderTraversal(root: TreeNode?): List<Int> {
        result.clear()
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

                pop.node.let {
                    stack.push(Command("print", it))
                }

                pop.node.left?.let {
                    stack.push(Command("go", it))
                }
            }
        }

        return result
    }
        //递归
//        if (root == null) {
//            return result
//        }
//
//        if (root.left != null) {
//            inorderTraversal(root.left)
//        }
//
//        result.add(root.`val`)
//
//        if (root.right != null) {
//            inorderTraversal(root.right)
//        }
//
//        return result
        /*
        测试用例1：
                1
               / \
              2   3
             / \   \
            4   5   6

        中序遍历： [4, 2, 5, 1, 3, 6]
     */
        //迭代
//        val stack = Stack<TreeNode>()
//
//        var cur = root
//        while (cur != null || stack.isNotEmpty()) {
//            while (cur != null) {
//                stack.push(cur)
//                cur = cur.left
//            }
//            cur = stack.pop()
//            result.add(cur.`val`)
//            cur = cur?.right
//        }
//
//        return result
//    }
}

fun main() {
    /*
        测试用例1：
                1
               / \
              2   3
             / \   \
            4   5   6

        中序遍历： [4, 2, 5, 1, 3, 6]
     */
    val root1 = TreeNode(1)
    root1.left = TreeNode(2)
    root1.right = TreeNode(3)
    root1.left!!.left = TreeNode(4)
    root1.left!!.right = TreeNode(5)
    root1.right!!.right = TreeNode(6)
    LeetCode94.result.clear()
    println("用例1 中序遍历: ${LeetCode94.inorderTraversal(root1)}")

    /*
        测试用例2：
        单节点
        中序遍历： [1]
     */
    val root2 = TreeNode(1)
    LeetCode94.result.clear()
    println("用例2 中序遍历: ${LeetCode94.inorderTraversal(root2)}")

    /*
        测试用例3：
        空树
        中序遍历： []
     */
    val root3: TreeNode? = null
    LeetCode94.result.clear()
    println("用例3 中序遍历: ${LeetCode94.inorderTraversal(root3)}")
}