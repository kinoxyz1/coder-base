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
 * 链表反转
 *
 * @author kino
 * @date 2023/4/13 16:36
 */
public class ReverseLinkedList {

    /**
     * 方法一: 遍历要反转的链表, 每次取一个node的value, 创建一个新的 node 加到 resultNode 最前面
     *
     * @param node 要反转的链表
     * @return 反转后的链表
     */
    public static ListNode reverseLinkedList1(ListNode node) {
        if (null == node || node.next == null) {
            return node;
        }
        ListNode resultNode = null;
        while (node != null) {
            resultNode = new ListNode(node.val, resultNode);
            node = node.next;
        }
        return resultNode;
    }

    /**
     * 方法二: 在方法一的基础上, 原数组直接 move 一个 node 并返回, 然后插入到 resultNode 最前面
     * node1: 1,2,3,4,5  | 2,3,4,5 | 3,4,5 | 4,5     | 5        |
     * node2:            | 1       | 1,2   | 1,2,3   | 1,2,3,4  | 1,2,3,4,5
     *
     * @param node 要反转的链表
     * @return 反转后的链表
     */
    public static ListNode reverseLinkedList2(ListNode node) {
        if (null == node || node.next == null) {
            return node;
        }
        List oldNode = new List(node);
        List resultNode = new List(null);
        ListNode remoteNode;
        while ((remoteNode = oldNode.remoteFirst()) != null) {
            resultNode.addFirst(remoteNode);
        }
        return resultNode.head;
    }
    private static class List {
        ListNode head;
        public List(ListNode head) {
            this.head = head;
        }
        void addFirst(ListNode addNode){
            addNode.next = head;
            head = addNode;
        }
        ListNode remoteFirst(){
            ListNode remote = head;
            if (remote != null) {
                head = remote.next;
            }
            return remote;
        }
    }

    /**
     * 方法三: 在方法二的基础上, 设置两个指针在原链表上做改变.
     *       p1
     *       p2
     * node  1 -> 2 -> 3 -> 4 -> null
     *       p2   p1
     * node  2 -> 1 -> 3 -> 4 -> null
     *            p1   p2
     * node  2 -> 1 -> 3 -> 4 -> null
     *       p2        p1
     * node  3 -> 2 -> 1 -> 4 -> null
     *                 p1   p2
     * node  3 -> 2 -> 1 -> 4 -> null
     * @param node 要反转的链表
     * @return 反转后的链表
     */
    public static ListNode reverseLinkedList3(ListNode node) {
        if (null == node || node.next == null) {
            return node;
        }
        ListNode p1 = node;
        ListNode p2 = node.next;
        while (p2 != null) {
            node.next = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = node.next;
        }
        return p1;
    }

    /**
     * 方法四: 在方法二的基础上, 用面向过程的方式实现
     * @param node
     * @return
     */
    public static ListNode reverseLinkedList4(ListNode node) {
        if (null == node || node.next == null) {
            return node;
        }
        ListNode newNode = null;
        while (node != null) {
            ListNode next = node.next;
            newNode = new ListNode(node.val, newNode);
            node = next;
        }
        return newNode;
    }

    /**
     * 方法五: 递归实现
     * @param node
     * @return
     */
    public static ListNode reverseLinkedList(ListNode node) {
        if(node == null || node.next == null){
            return node;
        }
        ListNode last = reverseLinkedList(node.next);
        node.next.next = node;
        node.next = null;
        return last;
    }
}


