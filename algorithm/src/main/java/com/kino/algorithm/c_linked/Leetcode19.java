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
 * @date 2023/4/19 23:53
 */
public class Leetcode19 {
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
