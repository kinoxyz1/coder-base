package com.kino.algorithm.c_linked;

import java.util.List;

/**
 * 根据值删除节点
 *
 * @author kino
 * @date 2023/4/17 01:44
 */
public class RemoveLinkedListByValue {
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
}
