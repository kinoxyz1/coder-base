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
