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
