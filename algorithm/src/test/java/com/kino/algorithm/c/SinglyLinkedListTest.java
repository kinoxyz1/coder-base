package com.kino.algorithm.c;

import org.junit.jupiter.api.Test;

/**
 * @author kino
 * @date 2023/3/21 00:49
 */
public class SinglyLinkedListTest {
    @Test
    public void test() throws IllegalAccessException {
        SinglyLinkedList list = new SinglyLinkedList();

        list.addLast(4);
        list.addLast(5);
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        list.addLast(6);

        list.loop1(System.out::println);
//        list.loop2(System.out::println);
//        for (Integer value : list) {
//            System.out.println(value);
//        }

        System.out.println("=====");
        System.out.println(list.getValue(0));
        System.out.println(list.getValue(1));
        System.out.println(list.getValue(2));
        System.out.println(list.getValue(3));
        System.out.println(list.getValue(4));
        System.out.println(list.getValue(5));
        System.out.println(list.getValue(6));
    }
}
