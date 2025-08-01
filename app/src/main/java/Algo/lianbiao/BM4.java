package Algo.lianbiao;

/**
 * 合并有序链表
 *
 * 思路：双指针法：
 */
class BM4 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param pHead1 ListNode类
     * @param pHead2 ListNode类
     * @return ListNode类
     */
    public static ListNode Merge(ListNode pHead1, ListNode pHead2) {
        // write code here
        ListNode dummyNode = new ListNode(-1);
        ListNode result = dummyNode;
        while ((pHead1 != null) && (pHead2 != null)) {
            if (pHead1.val < pHead2.val) {
                dummyNode.next = pHead1;
                dummyNode = dummyNode.next;
                pHead1 = pHead1.next;
            } else {
                dummyNode.next = pHead2;
                dummyNode = dummyNode.next;
                pHead2 = pHead2.next;
            }
        }

        if (pHead1 != null) {
            dummyNode.next = pHead1;
        } else if (pHead2 != null) {
            dummyNode.next = pHead2;
        }

        return result.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = ListNode.arrayToListNode(new int[]{-1, 2, 4});
        ListNode listNode2 = ListNode.arrayToListNode(new int[]{1, 3, 4});
        ListNode.print(Merge(listNode1, listNode2));
    }
}
