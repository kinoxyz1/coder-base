package com.kino.algorithm.c_linked;

/**
 * 根据值删除节点
 *
 * @author kino
 * @date 2023/4/17 01:44
 */
public class RemoveLinkedListByValue {
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

    // ------------------ leetcode 19 的两种实现
    /*
        n=2
        p1
        p2
        s -> 1 -> 2 -> 3 -> 4 -> 5 -> null

             p2
        s -> 1 -> 2 -> 3 -> 4 -> 5 -> null

                  p2
        s -> 1 -> 2 -> 3 -> 4 -> 5 -> null

        p1             p2
        s -> 1 -> 2 -> 3 -> 4 -> 5 -> null

                       p1             p2
        s -> 1 -> 2 -> 3 -> 4 -> 5 -> null
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode s = new ListNode(-1, head);
        ListNode p1 = s;
        ListNode p2 = s;
        for (int i = 0; i < n + 1; i++) {
            p2 = p2.next;
        }
        while (p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = p1.next.next;
        return s.next;
    }

    // 递归实现
    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode s = new ListNode(-1, head);
        recursion(s, n);
        return s.next;
    }

    public static int recursion(ListNode head, int n) {
        if (head == null) {
            return 0;
        }
        int num = recursion(head.next, n);
        if(num == n){
            head.next = head.next.next;
        }
        return ++num;
    }

    public static void main(String[] args) {
        ListNode list5 = new ListNode(5, null);
        ListNode list4 = new ListNode(4, list5);
        ListNode list3 = new ListNode(3, list4);
        ListNode list2 = new ListNode(2, list3);
        ListNode node = new ListNode(1, list2);
        System.out.println(removeNthFromEnd2(node, 2));;
    }
}
