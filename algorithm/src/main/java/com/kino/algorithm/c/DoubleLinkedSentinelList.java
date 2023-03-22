package com.kino.algorithm.c;

import java.util.Iterator;

/**
 * 双向链表(哨兵)
 *
 * @author kino
 * @date 2023/3/23 01:40
 */
public class DoubleLinkedSentinelList implements Iterable<Integer>{

    private Node head;
    private Node tail;

    public DoubleLinkedSentinelList() {
        head = new Node(null, Integer.MIN_VALUE, null);
        tail = new Node(null, Integer.MAX_VALUE, null);

        head.next = tail;
        tail.prev = head;
    }

    private static class Node {
        private Node prev;
        private int value;
        private Node next;

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node point = head.next;
            @Override
            public boolean hasNext() {
                return point != tail;
            }

            @Override
            public Integer next() {
                int value = point.value;
                point = point.next;
                return value;
            }
        };
    }

    /**
     * 获取指定位置的Node(从前往后找)
     * @param index
     * @return
     */
    private Node findNode(int index){
        int i = -1;
        for(Node point = head; point.next != null; point = point.next, i++){
            if(index == i){
                return point;
            }
        }
        return null;
    }

    /**
     * 获取指定位置的value
     * @param index
     * @return
     */
    public int get(int index) throws IllegalAccessException {
        Node node = findNode(index);
        if(null == node){
            throw new IllegalAccessException(String.format("index [%d] 不合法%n", index));
        }
        return node.value;
    }

    /**
     * 向最前面插入记录
     */
    public void addFirst(int value){
        Node next = head.next;
        Node node = new Node(head, value, next); // 改变 新创建的 Node 的指针
        head.next = node; // 改变 头 的下一个节点为 当前创建的 node
        next.prev = node; // 改变 尾 的上一个节点为 当前创建的 node
    }

    /**
     * 向最后面插入记录
     */
    public void addLast(int value) {
        Node prev = tail.prev;
        Node node = new Node(prev, value, tail);
        prev.next = node;
        tail.prev = node;
    }

    /**
     * 向指定位置插入记录
     * @param index
     * @param value
     */
    public void insert(int index, int value) throws IllegalAccessException {
        Node findNode = findNode(index);
        if(null == findNode){
            throw new IllegalAccessException(String.format("index [%d] 不合法%n", index));
        }
        Node prev = findNode.prev;
        if(null == prev){
            throw new IllegalAccessException(String.format("index [%d] 不合法%n", index));
        }
        Node newNode = new Node(prev, value, findNode);
        prev.next = newNode;
        findNode.prev = newNode;
    }


}
