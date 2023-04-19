package com.kino.algorithm.c_linked;

/**
 * 根据值删除节点
 *
 * @author kino
 * @date 2023/4/17 01:44
 */
public class Leetcode203 {
    // ------------------ leetcode 203 的两种实现方式
    /**
     * 用哨兵双指针的方式
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements(ListNode head, int val) {
        if (null == head) {
            return head;
        }
        ListNode result = new ListNode(-1, head);
        ListNode point1 = result;
        ListNode point2;
        while ((point2 = point1.next) != null) {
            if (point2.val == val) {
                point1.next = point2.next;
            } else {
                point1 = point2;
            }
        }
        return result.next;
    }

    public static ListNode recursionRemoveElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return recursionRemoveElements(head.next, val);
        } else {
            head.next = recursionRemoveElements(head.next, val);
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode list5 = new ListNode(5, null);
        ListNode list4 = new ListNode(4, list5);
        ListNode list3 = new ListNode(3, list4);
        ListNode list2 = new ListNode(2, list3);
        ListNode node = new ListNode(1, list2);
        System.out.println(recursionRemoveElements(node, 2));;
    }
}
