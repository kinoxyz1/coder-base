package com.kino.algorithm.c;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author kino
 * @date 2023/3/22 23:19
 */
public class SinglyLinkedSentinelListTest {
    @Test
    public void test() throws IllegalAccessException {
        SinglyLinkedSentinelList list = new SinglyLinkedSentinelList();
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);

        list.insert(0, 10);
        list.insert(1, 20);
        list.insert(2, 30);

        list.removeFirst();
        list.removeFirst();
        list.remove(-1);

        for (Integer value : list) {
            System.out.println(value);
        }
    }
}
