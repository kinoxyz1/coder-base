package com.kino.algorithm.f_queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author kino
 * @date 2023/5/2 22:16
 */
public class ArrayQueueTest {
    @Test
    public void offer(){
        ArrayQueue<Integer> queue = new ArrayQueue<>(3);
        Assertions.assertTrue(queue.offer(1));
        Assertions.assertTrue(queue.offer(2));
        Assertions.assertTrue(queue.offer(3));
        Assertions.assertFalse(queue.offer(4));
        for (Integer value : queue) {
            System.out.println(value);
        }
    }
}
