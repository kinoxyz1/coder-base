package com.kino.algorithm.c;

import java.util.Iterator;

/**
 * 单向链表(哨兵)
 * @author kino
 * @date 2023/3/22 14:30
 */
public class SinglyLinkedSentinelList<E> implements Iterable<E> {
    transient int size = 0;
    private final Node<E> head;

    public SinglyLinkedSentinelList() {
        head = new Node<E>(null, null);  // 哨兵
    }

    /**
     * 找指定下标的 Node
     *
     * @param index
     * @return
     * @throws IllegalAccessException
     */
    private Node<E> findNode(int index) throws IllegalAccessException {
        int size = -1;
        for (Node<E> point = head; point != null; point = point.next, size++) {
            if (size == index) {
                return point;
            }
        }
        return null;
    }

    /**
     * 找指定下标的 value
     *
     * @param index
     * @return
     * @throws IllegalAccessException
     */
    public E get(int index) throws IllegalAccessException {
        checkIndex(index);
        Node<E> node = findNode(index);
        if (null == node) {
            throw throwIllegalAccessException(index);
        }
        return node.value;
    }

    /**
     * 向链表最前面添加一个记录
     *
     * @param value
     */
    public void addFirst(E value) {
        Node<E> curr = head;
        Node next = curr.next;
        curr.next = new Node<E>(value, next);
        size++;
    }

    /**
     * 向链表最后添加一条记录
     * @param value
     */
    public void addLast(E value) throws IllegalAccessException {
        Node<E> lastNode = findNode(size - 1);
        lastNode.next = new Node(value,null);
        size++;
    }

    /**
     * 移除第一个元素
     */
    public void removeFirst() throws IllegalAccessException {
        Node<E> node = findNode(0);
        if(null == node){
            throw new IllegalAccessException("0");
        }
        Node next = node.next;
        head.next = next;
        size--;
    }

    /**
     * 移除最后一个元素
     */
    public void removeLast() throws IllegalAccessException {
        // 链表为空的时候, 直接抛异常
        if(size == 0){
            throw throwIllegalAccessException(size);
        }
        Node<E> lastPrevNode = findNode(size - 2);
        lastPrevNode.next = null;
        size--;
    }

    /**
     * 移除指定位置的元素
     * @param index
     */
    public void remove(int index) throws IllegalAccessException {
        if(index <= -1 || index > size -1){ // index 不合法
            throw throwIllegalAccessException(index);
        }
        Node<E> prevNode = findNode(index - 1); // 被移除元素的上一个
        Node removed = prevNode.next; // 被移除元素
        Node nextNode = removed.next; // 被移除元素的下一个
        prevNode.next = nextNode;
        size--;
    }

    /**
     * 向链表中的指定位置添加一条记录
     *
     * @param index 索引
     * @param value 值
     */
    public void add(int index, E value) throws IllegalAccessException {
        Node<E> prev = findNode(index-1);
        if (null == prev) {
            throw throwIllegalAccessException(index);
        }
        Node next = prev.next;
        prev.next = new Node<E>(value, next);
        size++;
    }

    /**
     * 异常处理
     *
     * @param index
     * @return
     */
    private static IllegalAccessException throwIllegalAccessException(int index) {
        return new IllegalAccessException(String.format("index: %s 非法.", index));
    }

    /**
     * 校验 index 的合法性
     * @param index
     * @throws IllegalAccessException
     */
    private void checkIndex(int index) throws IllegalAccessException {
        if(index <= -1 || index > size){
            throw throwIllegalAccessException(index);
        }
    }

    private static class Node<E> {
        private E value;  // 链表的一个记录
        private Node next;  // 链表的下一个记录

        public Node(E value, Node next) {
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
                return point != null;
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
