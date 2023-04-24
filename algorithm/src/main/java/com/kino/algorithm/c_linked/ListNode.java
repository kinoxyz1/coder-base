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
 * 链表类
 * @author kino
 * @date 2023/4/13 17:05
 */
public class ListNode{

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode append(ListNode last) {
        ListNode p = this;
        while (p.next != null) {
            p = p.next;
        }
        p.next = last;
        return p;
    }

    public static ListNode of(int... elements) {
        if (elements.length == 0) {
            return null;
        }
        ListNode p = null;
        for (int i = elements.length - 1; i >= 0; i--) {
            p = new ListNode(elements[i], p);
        }
        return p;
    }

    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder(64);
       sb.append("[");
       ListNode p = this;
       while (p != null) {
           sb.append(p.val);
           if (p.next != null) {
               sb.append(",");
           }
           p = p.next;
       }
       sb.append("]");
       return sb.toString();
        // return String.valueOf(this.value);
    }
}
