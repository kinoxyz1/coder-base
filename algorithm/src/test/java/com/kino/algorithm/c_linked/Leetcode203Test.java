package com.kino.algorithm.c_linked;

import org.junit.jupiter.api.Test;

/**
 * @author kino
 * @date 2023/4/17 01:46
 */
public class Leetcode203Test {
    @Test
    public void test1() {
        ListNode list5 = new ListNode(5, null);
        ListNode list4 = new ListNode(4, list5);
        ListNode list3 = new ListNode(4, list4);
        ListNode list2 = new ListNode(2, list3);
        ListNode node = new ListNode(1, list2);
        System.out.println(Leetcode203.recursionRemoveElements(node, 4));
        // System.out.println(RemoveLinkedListByValue.removeElements(node, 2));
        // System.out.println(RemoveLinkedListByValue.removeElements(node, 3));
        // System.out.println(RemoveLinkedListByValue.removeElements(node, 4));
        // System.out.println(RemoveLinkedListByValue.removeElements(node, 5));
    }
}
