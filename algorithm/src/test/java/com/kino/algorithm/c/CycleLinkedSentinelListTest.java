package com.kino.algorithm.c;

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
}
