package com.kino.algorithm.c;

import java.util.Iterator;

/**
 * 环形链表(哨兵)
 * @author kino
 * @date 2023/3/25 01:33
 */
public class CycleLinkedSentinelList<E> implements Iterable<E> {

    transient int size = 0; // 链表大小
    private Node<E> sentinel;

    public void addFirst(E value){
        Node<E> next = sentinel.next;
        Node<E> added = new Node<>(sentinel, value, next);
        sentinel.next = added;
        next.prev = added;
        size++;
    }

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
