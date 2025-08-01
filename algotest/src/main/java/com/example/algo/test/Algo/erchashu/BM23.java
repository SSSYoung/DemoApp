package com.example.algo.test.Algo.erchashu;

import java.util.ArrayList;
import java.util.Stack;

//二叉树的前序遍历 根->左->右
class BM23 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 递归的解法
     * @param root TreeNode类
     * @return int整型一维数组
     */
    // public int[] preorderTraversal(TreeNode root) {
    //     // write code here
    //     ArrayList<Integer> list = new ArrayList<>();
    //     preorderTraversalSplit(root, list);
    //
    //     if (list.size() >= 1) {
    //         int[] result = new int[list.size()];
    //         for (int i = 0; i < list.size(); i++) {
    //             result[i] = list.get(i);
    //         }
    //         return result;
    //     } else {
    //         return new int[]{};
    //     }
    // }

    private void preorderTraversalSplit(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }

        list.add(root.val);
        preorderTraversalSplit(root.left, list);
        preorderTraversalSplit(root.right, list);
    }

    /**
     * 非递归的解法
     */


    public int[] preorderTraversal(TreeNode root) {
        // write code here
        if (root == null) {
            return new int[]{};
        }
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        //先入根节点
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            list.add(pop.val);
            //先进后出  所以先进右节点
            if (pop.right != null) {
                stack.push(pop.right);
            }

            if (pop.left != null) {
                stack.push(pop.left);
            }
        }

        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i ++) {
            arr[i] = list.get(arr.length - i - 1);
        }

        return arr;
    }

}
