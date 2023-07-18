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
package com.kino.algorithm.f_queue;

import java.util.Iterator;

/**
 * 用单向环形哨兵链表实现队列
 * @author kino
 * @date 2023/5/2 20:26
 */
public class LinkedListQueue<E> implements Queue<E>, Iterable<E> {

    private static class Node<E> {
        E val;
        Node<E> next;

        public Node(E val, Node<E> next) {
            this.val = val;
            this.next = next;
        }
    }

    private Node<E> head = new Node<>(null, null);
    private Node<E> tail = head;
    int size;
    int capacity;

    {
        tail.next = head;
    }

    public LinkedListQueue(int capacity) {
        this.capacity = capacity;
    }

    public LinkedListQueue() {

    }

    @Override
    public boolean offer(E value) {
        if (isFull()) return false;
        Node<E> added = new Node<>(value, head);
        tail.next = added;
        tail = added;
        size++;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) return null;
        Node<E> remote = head.next;
        head.next = remote.next;
        if (remote == tail) tail = remote;
        size--;
        return remote.val;
    }

    @Override
    public E peek() {
        if (isEmpty()) return null;
        return head.next.val;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> point = head.next;
            @Override
            public boolean hasNext() {
                return point != head;
            }

            @Override
            public E next() {
                E val = point.val;
                point = point.next;
                return val;
            }
        };
    }
}
