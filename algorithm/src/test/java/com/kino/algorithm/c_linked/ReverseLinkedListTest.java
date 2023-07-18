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

        ListNode listNode = ReverseLinkedList.reverseLinkedList4(node);
        System.out.println(listNode);
    }
}
