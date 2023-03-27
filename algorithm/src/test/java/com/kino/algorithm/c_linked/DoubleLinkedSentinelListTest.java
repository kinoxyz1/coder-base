package com.kino.algorithm.c_linked;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author kino
 * @date 2023/3/25 00:42
 */
public class DoubleLinkedSentinelListTest {
    @Test
    @DisplayName("测试 addFirst 方法")
    public void testAddFirst() throws IllegalAccessException {
        DoubleLinkedSentinelList<String> list = new DoubleLinkedSentinelList<String>();
        list.addFirst("3");
        list.addFirst("2");
        list.addFirst("1");
        Assertions.assertIterableEquals(Arrays.asList("1", "2", "3"), list);
    }

    @Test
    @DisplayName("测试 addLast 方法")
    public void testAddLast() throws IllegalAccessException {
        DoubleLinkedSentinelList<String> list = new DoubleLinkedSentinelList<String>();
        list.addLast("1");
        list.addLast("2");
        list.addLast("3");
        Assertions.assertIterableEquals(Arrays.asList("1", "2", "3"), list);
    }

    @Test
    @DisplayName("测试 addAdd 方法")
    public void testAdd() throws IllegalAccessException {
        DoubleLinkedSentinelList<String> list = new DoubleLinkedSentinelList<String>();
        list.add(0, "1");
        list.add(1, "2");
        list.add(2, "3");
        Assertions.assertIterableEquals(Arrays.asList("1", "2", "3"), list);
        Assertions.assertThrows(IllegalAccessException.class, () -> list.add(-1, "-100"));
        Assertions.assertThrows(IllegalAccessException.class, () -> list.add(4, "300"));
    }

    @Test
    @DisplayName("测试 Get 方法")
    public void testGet() throws IllegalAccessException {
        DoubleLinkedSentinelList<String> list = new DoubleLinkedSentinelList<String>();
        list.addLast("1");
        list.addLast("2");
        list.addLast("3");

        Assertions.assertThrows(IllegalAccessException.class, () -> list.get(-1));
        Assertions.assertEquals("1", list.get(0));
        Assertions.assertEquals("2", list.get(1));
        Assertions.assertEquals("3", list.get(2));
        Assertions.assertThrows(IllegalAccessException.class, () -> list.get(3));

    }

    @Test
    @DisplayName("测试 removeFirst 方法")
    public void testRemoveFirst() throws IllegalAccessException {
        DoubleLinkedSentinelList<String> list = new DoubleLinkedSentinelList<>();
        list.addLast("1");
        list.addLast("2");
        list.addLast("3");

        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        Assertions.assertThrows(IllegalAccessException.class, list::removeFirst);
    }

    @Test
    @DisplayName("测试 removeLast 方法")
    public void testRemoveLast() throws IllegalAccessException {
        DoubleLinkedSentinelList<String> list = new DoubleLinkedSentinelList<>();
        list.addLast("1");
        list.addLast("2");
        list.addLast("3");

        list.removeLast();
        list.removeLast();
        list.removeLast();
        Assertions.assertThrows(IllegalAccessException.class, list::removeLast);
    }

    @Test
    @DisplayName("测试 remove 方法")
    public void testRemove() throws IllegalAccessException {
        DoubleLinkedSentinelList<String> list = new DoubleLinkedSentinelList<>();
        list.addLast("1");
        list.addLast("2");
        list.addLast("3");

        Assertions.assertThrows(IllegalAccessException.class, () -> list.remove(-1));
        list.remove(1);
        list.remove(0);
        list.remove(0);
        Assertions.assertThrows(IllegalAccessException.class, () -> list.remove(1));
    }
}
