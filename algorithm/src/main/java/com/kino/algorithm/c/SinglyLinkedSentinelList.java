package com.kino.algorithm.c;

import java.util.Iterator;

/**
 * 单向链表(哨兵)
 * @author kino
 * @date 2023/3/22 14:30
 */
public class SinglyLinkedSentinelList implements Iterable<Integer>{

    public Node sentinel;  // 哨兵

    public SinglyLinkedSentinelList() {
        this.sentinel = new Node(Integer.MIN_VALUE, null);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node point = sentinel.next;
            @Override
            public boolean hasNext() {
                return point != null;
            }

            @Override
            public Integer next() {
                int value = point.value;
                point = point.next;
                return value;
            }
        };
    }

    private static class Node {
        private Node next;
        private int value;

        public Node(int value, Node next) {
            this.next = next;
            this.value = value;
        }
    }

    /**
     * 获取最后一个节点
     * @return
     */
    private Node getLastNode() {
        Node point = null;
        for(point = sentinel; point.next != null; point = point.next){

        }
        return point;
    }

    /**
     * 查找指定下标的Node
     * @param index
     * @return
     */
    public Node findNode(int index) {
        int i = -1;
        for(Node point = sentinel; point != null; point = point.next, i++){
            if(i == index){
                return point;
            }
        }
        return null;
    }

    /**
     * 获取指定下标Node的value
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
     * 向最开始添加记录
     * @param value
     */
    public void addFirst(int value) throws IllegalAccessException {
        insert(0, value);
    }

    /**
     * 向最后面添加记录
     * @param value
     */
    public void addLast(int value){
        getLastNode().next = new Node(value, null);
    }

    /**
     * 向指定下标位置插入记录
     * @param index
     * @param value
     */
    public void insert(int index, int value) throws IllegalAccessException {
        Node node = findNode(index-1);
        if(null == node){
            throw new IllegalAccessException(String.format("index [%d] 不合法%n", index));
        }
        node.next = new Node(value, node.next);
    }

    /**
     * 移除第一个元素
     */
    public void removeFirst(){
        Node first = sentinel.next;
        sentinel.next = first.next;
    }

    /**
     * 移除指定位置的元素
     */
    public void remove(int index) throws IllegalAccessException {
        Node prev = findNode(index - 1);
        if(null == prev){
            throw new IllegalAccessException(String.format("index [%d] 不合法%n", index));
        }
        Node mid = prev.next;
        if(null == mid){
            throw new IllegalAccessException(String.format("index [%d] 不合法%n", index));
        }
        prev.next = mid.next;
    }
}
