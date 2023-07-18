/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.kino.algorithm.c_linked;

/**
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 *
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 *
 * 提示：
 *
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序 排列
 * @author kino
 * @date 2023/4/20 00:47
 */
public class Leetcode82 {

    // 递归
    public static ListNode deleteDuplicates(ListNode head) {
        if (null == head || head.next == null) {
            return head;
        }
        if (head.val == head.next.val) {
            while (head.next != null && head.next.val == head.val) {
                head = head.next;
            }
            return deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }

    // 哨兵双指针
    public static ListNode deleteDuplicates1(ListNode head) {
        if (null == head || head.next == null) {
            return head;
        }
        ListNode s = new ListNode(-999, head);
        ListNode p1 = s;
        ListNode p2;
        while ((p2 = p1.next) != null) {
            while (p2.next != null && p2.val == p2.next.val) {
                p2 = p2.next;
            }
            if (p1.next != p2) {
                p1.next = p2.next;
            } else {
                p1 = p2;
            }
        }
        return s.next;
    }

    // 哨兵三指针
    public static ListNode deleteDuplicates2(ListNode head) {
        if (null == head || head.next == null) {
            return head;
        }
        ListNode s = new ListNode(-999, head);
        ListNode p1 = s;
        ListNode p2 = p1.next;
        ListNode p3 = p2.next;
        while (p3 != null) {
            if (p2.val == p3.val) {
                while (p3 != null &&  p3.val == p2.val) {
                    p3= p3.next;
                }
                p1.next = p3;
                p2 = p3;
                if (p3 != null) {
                    p3 = p3.next;
                }
            } else {
                p1 = p2;
                p2 = p3;
                p3 = p3.next;
            }
        }
        return s.next;
    }

    public static void main(String[] args) {
        System.out.println(deleteDuplicates(ListNode.of(1,1,1,2,3)));
    }
}
