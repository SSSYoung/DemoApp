package Algo.erchashu;

import java.util.ArrayList;
import java.util.Stack;

//二叉树的后续遍历，左------右------根
class BM25 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 递归法
     *
     * @param root TreeNode类
     * @return int整型一维数组
     */
    // public int[] postorderTraversal(TreeNode root) {
    //     // write code here
    //     if (root == null) {
    //         return new int[]{};
    //     }
    //     ArrayList<Integer> list = new ArrayList<>();
    //     postorderTraversal(list, root);
    //     return list.stream().mapToInt(value -> value).toArray();
    // }
    //
    // private void postorderTraversal(ArrayList<Integer> list, TreeNode node) {
    //     if (node == null) {
    //         return;
    //     }
    //
    //     postorderTraversal(list, node.left);
    //     postorderTraversal(list, node.right);
    //     list.add(node.val);
    // }

    public int[] postorderTraversal (TreeNode root) {
        // write code here
        if (root == null) {
            return new int[]{};
        }

        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        /**
         * 参考前序遍历
         */
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            list.add(node.val);
            if (node.left != null) {
                s.push(node.left);
            }

            if (node.right != null) {
                s.push(node.right);
            }
        }

        return list.stream().mapToInt(value -> value).toArray();
    }
}