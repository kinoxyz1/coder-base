package com.kino.algorithm.c_linked;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * 单向链表
 *
 * @author kino
 * @date 2023/3/21 00:41
 */
public class SinglyLinkedList implements Iterable<Integer> {
    private Node head;  // 链表的头

    /**
     * 链表的节点
     */
    private static class Node {
        private int value;
        private Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    /**
     * 往头部插入
     */
    public void addFirst(int value) {
        head = new Node(value, head);
    }

    /**
     * 往尾部插入
     *
     * @param value
     */
    public void addLast(int value) {
        // 判空
        if (head == null) {
            addFirst(value);
            return;
        }
        // 首先找到最后一个 Node
        Node lastNode = getLastNode();
        lastNode.next = new Node(value, null);
    }

    /**
     * 遍历链表(for)
     */
    public void loop1(Consumer<Integer> consumer) {
        for (Node point = head; point != null; point = point.next) {
            consumer.accept(point.value);
        }
    }

    /**
     * 遍历列表(while)
     */
    public void loop2(Consumer<Integer> consumer) {
        Node point = head;
        while (point != null) {
            consumer.accept(point.value);
            point = point.next;
        }
    }

    /**
     * 遍历列表(增强for)
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node point = head;

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

    /**
     * @return 获取第一个 Node
     */
    public Node getFirstNode() {
        return head;
    }

    /**
     * @return 获取最后一个 Node
     */
    public Node getLastNode() {
        Node point = null;
        for (point = head; point.next != null; point = point.next) {

        }
        return point;
    }

    /**
     * 获取指定下标的 Node
     * @param index
     * @return
     */
    public Node findNode(int index) {
        Node point = null;
        int idx = 0;
        for (point = head; point != null; point = point.next, idx++) {
            if (idx == index) {
                return point;
            }
        }
        return null;
    }
    /**
     * 获取指定位置的 Noe
     * @param index 下标
     * @return Node
     */
    private Node get(int index) throws IllegalAccessException {
        Node node = findNode(index);
        if(node == null) {
            throw new IllegalAccessException(String.format("index [%d] 不合法%n", index));
        }
        return node;
    }

    /**
     * 获取指定位置的 Node 的 value
     * @param index 下标
     * @return value
     */
    public int getValue(int index) throws IllegalAccessException {
        Node node = get(index);
        if(node == null) {
            throw new IllegalAccessException(String.format("index [%d] 不合法%n", index));
        }
        return node.value;
    }
}
