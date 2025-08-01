package com.example.algo.test.Algo.erchashu;

import java.util.ArrayList;
import java.util.Stack;

//中序遍历：左->根->右
class BM24 {
    // /**
    //  * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
    //  * 递归
    //  *
    //  * @param root TreeNode类
    //  * @return int整型一维数组
    // public int[] inorderTraversal (TreeNode root) {
    //     // write code here
    //     ArrayList<Integer> list = new ArrayList<>();
    //     inorderTravelsalSplit(list,root);
    //
    //     return list.stream().mapToInt(value -> value).toArray();
    // }
    //
    // private void inorderTravelsalSplit(ArrayList<Integer> list,TreeNode node) {
    //     if (node == null) {
    //         return;
    //     }
    //
    //     inorderTravelsalSplit(list,node.left);
    //     list.add(node.val);
    //     inorderTravelsalSplit(list,node.right);
    // }*/

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 迭代法
     *
     * @param root TreeNode类
     * @return int整型一维数组
     */
    public int[] inorderTraversal (TreeNode root) {
        // write code here
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root == null) {
            return new int[]{};
        }

        while ((root != null) || (!stack.isEmpty())) {
            while (root != null) {
                stack.push(root);
                //找到最根部循环停止
                root = root.left;
            }


            TreeNode pop = stack.pop();
            //根节点加入
            list.add(pop.val);
            // root重新变为右节点开始循环
            root = pop.right;
        }

        return list.stream().mapToInt(value -> value).toArray();
    }
}
