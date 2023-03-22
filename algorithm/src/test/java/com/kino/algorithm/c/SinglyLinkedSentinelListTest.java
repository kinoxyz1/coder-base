package com.kino.algorithm.c;

import org.junit.jupiter.api.Test;

/**
 * @author kino
 * @date 2023/3/22 23:19
 */
public class SinglyLinkedSentinelListTest {
    @Test
    public void test(){
        SinglyLinkedSentinelList list = new SinglyLinkedSentinelList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        System.out.println(list);
    }
}
