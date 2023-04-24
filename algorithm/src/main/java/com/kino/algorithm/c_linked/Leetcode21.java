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
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 示例 2：
 *
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 * 提示：
 *
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 *
 * @author kino
 * @date 2023/4/23 11:36
 */
public class Leetcode21 {
    /**
     *      list1: 1 2 4
     *      list2: 1 3 4
     *             p
     *      s      null
     *
     * step1:
     *      list1: 2 4
     *      list2: 1 3 4
     *               p
     *      s      1 null
     *
     * step2:
     *      list1: 2 4
     *      list2: 3 4
     *                 p
     *      s      1 1 null
     *
     * step3:
     *      list1: 4
     *      list2: 3 4
     *                   p
     *      s      1 1 2
     *
     * step4:
     *      list1: 4
     *      list2: 4
     *                     p
     *      s      1 1 2 3 null
     *
     * step5:
     *      list1: null
     *      list2: 4
     *                       p
     *      s      1 1 2 3 4 null
     *
     * step6:
     *      list1: null
     *      list2: null
     *                         p
     *      s      1 1 2 3 4 4 null
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        if (null == list1 && null == list2) {
            return null;
        }
        ListNode s = new ListNode(-999, null);
        ListNode p = s;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                p.next = list1;
                list1 = list1.next;
                p = p.next;
            } else {
                p.next = list2;
                list2 = list2.next;
                p = p.next;
            }
        }
        if (list1 != null) p.next = list1;
        if (list2 != null) p.next = list2;
        return s.next;
    }

    /**
     * list1: 1 2 4
     * list2: 1 3 4
     *
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    public static void main(String[] args) {
        ListNode list1 = ListNode.of(1,2,4);
        ListNode list2 = ListNode.of(1,3,4);
        System.out.println(mergeTwoLists(list1, list2));

    }
}
