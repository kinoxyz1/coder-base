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
 * @author kino
 * @date 2023/4/20 00:00
 */
public class Leetcode83 {

    // 单指针
    public static ListNode deleteDuplicates1(ListNode head) {
        if (null == head || head.next == null) {
            return head;
        }
        ListNode s = new ListNode(-999, head);
        ListNode p1 = s.next;
        while (p1 != null && p1.next != null) {
            if (p1.val == p1.next.val) {
                p1.next = p1.next.next;
            } else {
                p1 = p1.next;
            }
        }
        return s.next;
    }

    // 双指针
    public static ListNode deleteDuplicates2(ListNode head){
        if (null == head || head.next == null) {
            return head;
        }
        ListNode s = new ListNode(-999, head);
        ListNode p1 = s;
        ListNode p2;
        while ((p2 = p1.next) != null) {
            if (p1.val == p2.val) {
                p1.next = p2.next;
            } else {
                p1 = p1.next;
            }
        }
        return s.next;
    }

    // 递归
    public static ListNode deleteDuplicates(ListNode head){
        if (null == head || head.next == null) {
            return head;
        }
        if (head.val == head.next.val) {
            return deleteDuplicates1(head.next);
        } else {
            head.next = deleteDuplicates1(head.next);
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode of = ListNode.of(-1,0,0,0,0,3,3);
        System.out.println(deleteDuplicates(of));
    }
}
