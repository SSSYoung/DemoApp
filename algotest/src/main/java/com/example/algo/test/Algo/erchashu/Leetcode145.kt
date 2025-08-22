package com.example.algo.test.Algo.erchashu

import java.util.Stack

/**
 * @ProjectName: DemoApp
 * @Description:
 * @Author: uidq9989
 * @Date: 2025/8/12
 */
object Leetcode145 {
    val result = arrayListOf<Int>()
    fun postorderTraversal(root: TreeNode?): List<Int> {
        /*🔹 stack.push(Command("print", cmd.node)) 的作用

                在迭代框架里：

        "go" 表示“还要继续展开”

        "print" 表示“真正输出节点值”

        所以对于后序遍历，遇到一个节点时，我们不能立刻访问它，而是要先把左右子树任务压进去。
        但是，为了保证在左右子树都处理完之后还能回来访问这个节点，就要先压一个 "print" 版本的节点。

        代码对应逻辑是：

        if (cmd.type == "go") {
            // 后序：左 -> 右 -> 根
            stack.push(Command("print", cmd.node)) // 等左右都处理完再访问
            if (cmd.node.right != null) stack.push(Command("go", cmd.node.right))
            if (cmd.node.left  != null) stack.push(Command("go", cmd.node.left))
        }*/

        result.clear()
        // 统一迭代法后序遍历
        if (root == null) {
            return result
        }

        val stack = Stack<Command>()

        stack.push(Command("go", root))

        while (stack.isNotEmpty()) {
            val cmd = stack.pop()

            if (cmd.type == "print") {
                result.add(cmd.node.`val`)
            } else {
                stack.push(Command("print", cmd.node))
                cmd.node.right?.let {
                    stack.push(Command("go", it))
                }
                cmd.node.left?.let {
                    stack.push(Command("go", it))
                }
            }
        }

        return result


        //
//        if (root == null) {
//            return result
//        }
//
//        if (root.left != null) {
//          postorderTraversal(root.left)
//        }
//
//        if (root.right != null) {
//            postorderTraversal(root.right)
//        }
//
//        result.add(root.`val`)
//
//        return result
        //迭代


//        val stack = Stack<TreeNode>()
//        var cur = root
//        while (cur != null || stack.isNotEmpty()) {
//            while (cur?.left != null && cur.right != null) {
//                stack.push(cur)
//                cur = cur.left
//            }
//
//            if (cur?.left == null && cur?.right == null && stack.isNotEmpty()) {
//                val pop = stack.pop()
//                result.add(pop.`val`)
//            }
//
//            // 左不空 右空
//            if (cur?.left != null) {
//                result.add(cur.left!!.`val`)
//            }
//            // 左空 右不空
//            if (cur?.right != null) {
//                cur = cur.right
//            }
//        }
//
//        return result
    }
}


fun main() {
    /*
        构造的测试二叉树结构：
                1
               / \
              2   3
             / \   \
            4   5   6

        后序遍历顺序应为：
        [4, 5, 2, 6, 3, 1]
     */
    val root1 = TreeNode(1)
    root1.left = TreeNode(2)
    root1.right = TreeNode(3)
    root1.left!!.left = TreeNode(4)
    root1.left!!.right = TreeNode(5)
    root1.right!!.right = TreeNode(6)

    println("用例1 后序遍历结果: ${Leetcode145.postorderTraversal(root1)}")

    // 用例2：单节点
    val root2 = TreeNode(10)
    println("用例2 后序遍历结果: ${Leetcode145.postorderTraversal(root2)}")

    // 用例3：只有左子树
    val root3 = TreeNode(1)
    root3.left = TreeNode(2)
    root3.left!!.left = TreeNode(3)
    println("用例3 后序遍历结果: ${Leetcode145.postorderTraversal(root3)}")

    // 用例4：只有右子树
    val root4 = TreeNode(1)
    root4.right = TreeNode(2)
    root4.right!!.right = TreeNode(3)
    println("用例4 后序遍历结果: ${Leetcode145.postorderTraversal(root4)}")

    // 用例5：空树
    println("用例5 后序遍历结果: ${Leetcode145.postorderTraversal(null)}")
}
