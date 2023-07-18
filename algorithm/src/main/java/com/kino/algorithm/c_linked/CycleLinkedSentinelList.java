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

import java.util.Iterator;

/**
 * 环形链表(哨兵)
 * @author kino
 * @date 2023/3/25 01:33
 */
public class CycleLinkedSentinelList<E> implements Iterable<E> {
    transient int size = 0; // 链表大小
    private Node<E> sentinel;

    private Node<E> findNode(int index) throws IllegalAccessException {
        if(index <= -1 || index > size){
            throw throwIllegalAccessException(index);
        }
        int count = 0;
        for (Node<E> point = sentinel.next; point != sentinel; point = point.next, count++){
            if(index == count){
                return point;
            }
        }
        return null;
    }

    public void addFirst(E value){
        Node<E> next = sentinel.next;
        Node<E> added = new Node<>(sentinel, value, next);
        sentinel.next = added;
        next.prev = added;
        size++;
    }

    /**
     * 向链表最后添加一个元素
     * @param value
     */
    public void addLast(E value) {
        Node<E> prev = sentinel.prev;
        Node added = new Node(prev, value, sentinel);
        prev.next = added;
        sentinel.prev = added;
        size++;
    }

    /**
     * 向链表中的任意一个位置添加一个元素
     * @param index
     * @param value
     */
//    public void add(int index, E value) throws IllegalAccessException {
//        if(size == 0){
//            addFirst(value);
//            return;
//        }
//        if(size == 1){
//            addFirst(value);
//            return;
//        }
//        Node<E> point = findNode(index);
//        Node<E> prev = point.prev;
//        Node<E> added = new Node<>(prev, value, point);
//        prev.next = added;
//        point.prev = added;
//        size++;
//    }

    public CycleLinkedSentinelList() {
        // 初始化空链表
        sentinel = new Node<>(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    private static class Node<E> {
        private Node<E> prev;
        private E value;
        private Node<E> next;

        public Node(Node<E> prev, E value, Node<E> next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    private static IllegalAccessException throwIllegalAccessException(int index) {
        return new IllegalAccessException(String.format("index: %s 非法.", index));
    }
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> point = sentinel.next;
            @Override
            public boolean hasNext() {
                return point != sentinel;
            }

            @Override
            public E next() {
                E value = point.value;
                point = point.next;
                return value;
            }
        };
    }
}
