package com.kino.algorithm.c;

import javax.swing.*;

/**
 * 单向链表(哨兵)
 * @author kino
 * @date 2023/3/22 14:30
 */
public class SinglyLinkedSentinelList {

    public Node sentinel;  // 哨兵

    public SinglyLinkedSentinelList() {
        this.sentinel = new Node(Integer.MIN_VALUE, null);
    }

    private static class Node {
        private Node next;
        private int value;

        public Node(int value, Node next) {
            this.next = next;
            this.value = value;
        }
    }

    public Node findNode(int index) {
        int i = 0;
        for(Node point = sentinel; point.next != null; point = point.next, i++){
            if(i == index){
                return point;
            }
        }
        return null;
    }

    /**
     * 向最开始添加记录
     * @param value
     */
    public void addFirst(int value){
        Node s = sentinel;
        Node next = sentinel.next;
        s.next = new Node(value, next);
    }

    public void addLast(int value){

    }



}
