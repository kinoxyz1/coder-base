package com.kino.algorithm.f_queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author kino
 * @date 2023/5/3 22:10
 */
public class ArrayQueue2Test {
    @Test
    public void offer(){
        ArrayQueue2<Integer> queue = new ArrayQueue2<>(3);
        Assertions.assertTrue(queue.offer(1));
        Assertions.assertTrue(queue.offer(2));
        Assertions.assertTrue(queue.offer(3));
        Assertions.assertFalse(queue.offer(4));
        for (Integer value : queue) {
            System.out.println(value);
        }
    }

    @Test
    public void poll(){
        ArrayQueue2<Integer> queue = new ArrayQueue2<>(3);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        Assertions.assertEquals(1, queue.poll());
        Assertions.assertEquals(2, queue.poll());
        Assertions.assertEquals(3, queue.poll());
        Assertions.assertNull(queue.poll());
    }

    @Test
    public void peek(){
        ArrayQueue2<Integer> queue = new ArrayQueue2<>(3);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        Assertions.assertEquals(1, queue.peek());
        Assertions.assertEquals(1, queue.peek());
        Assertions.assertEquals(1, queue.peek());
    }
}
