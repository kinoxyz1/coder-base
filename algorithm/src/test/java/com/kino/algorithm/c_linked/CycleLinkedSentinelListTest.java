package com.kino.algorithm.c_linked;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author kino
 * @date 2023/3/25 01:36
 */
public class CycleLinkedSentinelListTest {
    @Test
    @DisplayName("测试 addFirst 方法")
    public void testAddFirst() {
        CycleLinkedSentinelList<String> list = new CycleLinkedSentinelList<>();
        list.addFirst("3");
        list.addFirst("2");
        list.addFirst("1");
        Assertions.assertIterableEquals(Arrays.asList("1", "2", "3"), list);
    }

    @Test
    @DisplayName("测试 addLast 方法")
    public void testAddLast() {
        CycleLinkedSentinelList<String> list = new CycleLinkedSentinelList<>();
        list.addLast("1");
        list.addLast("2");
        list.addLast("3");
        Assertions.assertIterableEquals(Arrays.asList("1", "2", "3"), list);
    }

//    @Test
//    @DisplayName("测试 add 方法")
//    public void testAdd() throws IllegalAccessException {
//        CycleLinkedSentinelList<String> list = new CycleLinkedSentinelList<>();
//        list.add(0, "3");
//        list.add(1, "2");
//        list.add(2, "1");
//        Assertions.assertIterableEquals(Arrays.asList("3", "2", "1"), list);
//    }
}
