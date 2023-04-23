package com.kino.algorithm.c_linked;

/**
 * @author kino
 * @date 2023/4/23 15:40
 */
public class Leetcode234 {
    public static boolean isPalindrome(ListNode head) {
        if (null == head || head.next == null) return true;
        ListNode p1 = head;
        ListNode p2 = head;

        ListNode o1 = head;
        ListNode n1 = null;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;

            o1.next = n1;
            n1 = o1;
            o1 = p1;
        }
        System.out.println(o1);
        System.out.println(n1);

        if (p2 != null) {
            o1 = o1.next;
        }

        while (n1 != null) {
            if (n1.val != o1.val) return false;
            n1 = n1.next;
            o1 = o1.next;
        }

        // ListNode revert;
        // ListNode head1 = p1;
        // if(head1 == null || head1.next == null){
        //     revert = head1;
        // } else {
        //     ListNode o = null;
        //     while (head1 != null) {
        //         ListNode next = head1.next; // 记录
        //         o = new ListNode(head1.val, o);
        //         head1 = next;
        //     }
        //     revert = o;
        // }
        //
        // while (revert != null) {
        //     if (revert.val != head.val) return false;
        //     revert = revert.next;
        //     head = head.next;
        // }
        return true;
    }

    public static void main(String[] args) {
        ListNode list = ListNode.of(1,2,3,2,1);
        System.out.println(isPalindrome(list));
        ListNode list1 = ListNode.of(1,2,2,1);
        System.out.println(isPalindrome(list1));
        ListNode list2 = ListNode.of(1,1,2,2,1);
        System.out.println(isPalindrome(list2));
    }
}
