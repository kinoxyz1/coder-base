package com.kino.algorithm.c_linked;

/**
 * @author kino
 * @date 2023/4/23 15:01
 */
public class Leetcode876 {
    /**
     * 设置快慢指针
     *                      p1
     *                                            p2
     * 1  2  3  4  5  6  7  8  9  10  11  12  13  null
     * @param head
     * @return
     */
    public static ListNode middleNode(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }

    public static void main(String[] args) {
        ListNode list = ListNode.of(1, 2, 3, 4, 5, 6);
        System.out.println(middleNode(list));
    }
}
