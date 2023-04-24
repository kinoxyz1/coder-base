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
 * 双向链表(哨兵&泛型)
 *
 * @author kino
 * @date 2023/3/25 00:34
 */
public class DoubleLinkedSentinelList<E> implements Iterable<E> {
    transient int size = 0; // 链表大小
    private Node<E> head; // 头哨兵
    private Node<E> tail; // 尾哨兵

    /**
     * 向链表头插入一个记录(维护四个指针)
     * @param value
     */
    public void addFirst(E value) throws IllegalAccessException {
        add(0, value);
    }

    /**
     * 向链表尾插入一个记录
     * @param value
     */
    public void addLast(E value) throws IllegalAccessException {
        add(size, value);
    }

    /**
     * 向链表的指定位置插入一个记录
     * @param index
     * @param value
     */
    public void add(int index, E value) throws IllegalAccessException {
        Node<E> prev = findNode(index-1);
        if(null == prev){
            throw  throwIllegalAccessException(index);
        }
        Node<E> next = prev.next;  // 下一个节点
        Node<E> added = new Node<>(prev, value, next);
        prev.next = added;
        next.prev = added;
        size++;
    }

    /**
     * 查询指定下标的Node
     * @param index
     * @return
     */
    private Node<E> findNode(int index) {
        int size = -1;
        for(Node<E> point = head; point != tail; point = point.next, size++){
            if(size == index){
                return point;
            }
        }
        return null;
    }

    /**
     * 查询指定下标Node 的 value
     * @param index
     * @return
     */
    public E get(int index) throws IllegalAccessException {
        Node<E> point = findNode(index);
        if(null == point || point == head){
            throw  throwIllegalAccessException(index);
        }
        return point.value;
    }

    /**
     * 移除链表中的第一个元素
     */
    public void removeFirst() throws IllegalAccessException {
        remove(0);
    }

    /**
     * 移除链表中的最后一个元素
     */
    public void removeLast() throws IllegalAccessException {
        remove(size-1);
    }

    /**
     * 移除链表中指定位置的元素
     * @param index
     */
    public void remove(int index) throws IllegalAccessException {
        // 校验 index 合法
        if(index <= -1 || index > size){
            throw throwIllegalAccessException(index);
        }
        Node<E> removed = findNode(index); //被移除元素
        if (null == removed){
            throw throwIllegalAccessException(index);
        }
        Node<E> prev = removed.prev; // 被移除元素的上一个元素
        Node<E> next = removed.next; // 被移除元素的下一个元素
        prev.next = next;
        next.prev = prev;
        size--;
    }

    private static IllegalAccessException throwIllegalAccessException(int index) {
        return new IllegalAccessException(String.format("index: %s 非法.", index));
    }

    public DoubleLinkedSentinelList() {
        // 初始化一个空链表(头尾哨兵相连)
        head = new Node<>(null, null, null);
        tail = new Node<>(null, null, null);

        head.next = tail;
        tail.prev = head;
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

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> point = head.next;

            @Override
            public boolean hasNext() {
                return point != tail;
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
