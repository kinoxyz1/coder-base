package com.kino.algorithm.c_linked;

import org.junit.jupiter.api.Test;

/**
 * @author kino
 * @date 2023/4/13 16:43
 */
public class ReverseLinkedListTest {
    @Test
    public void test1(){
        ListNode list5 = new ListNode(5, null);
        ListNode list4 = new ListNode(4, list5);
        ListNode list3 = new ListNode(3, list4);
        ListNode list2 = new ListNode(2, list3);
        ListNode node = new ListNode(1, list2);

        ListNode listNode = ReverseLinkedList.reverseLinkedList(node);
        System.out.println(listNode);
    }
}
