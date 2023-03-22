package com.kino.algorithm.c;

import org.junit.jupiter.api.Test;

/**
 * @author kino
 * @date 2023/3/23 00:37
 */
public class DoubleLinkedlListTest {
    @Test
    public void test() throws IllegalAccessException {
        DoubleLinkedSentinelList list = new DoubleLinkedSentinelList();

        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);

        list.addLast(4);
        list.addLast(5);
        list.addLast(6);

//        list.insert(-1, 10);
        list.insert(0, 10);
        list.insert(2, 20);
        list.insert(4, 40);
//        list.insert(10, 50);

//        System.out.println(list.get(0));
//        System.out.println(list.get(1));
//        System.out.println(list.get(2));
//        System.out.println(list.get(3));
//        System.out.println(list.get(4));
//        System.out.println(list.get(5));
//        System.out.println(list.get(6));
//        System.out.println(list.get(7));
//        System.out.println(list.get(8));
//        System.out.println(list.get(9));


//        for (Integer value : list) {
//            System.out.println(value);
//        }
    }
}
