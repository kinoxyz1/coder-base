package com.kino.algorithm.f_queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author kino
 * @date 2023/5/3 23:10
 */
public class ArrayQueue3Test {
    @Test
    public void offer(){
        ArrayQueue3<Integer> queue = new ArrayQueue3<>(3);
        Assertions.assertTrue(queue.offer(1));
        Assertions.assertTrue(queue.offer(2));
        Assertions.assertTrue(queue.offer(3));
        for (Integer value : queue) {
            System.out.println(value);
        }
    }

    @Test
    public void poll(){
        ArrayQueue3<Integer> queue = new ArrayQueue3<>(3);
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
        ArrayQueue3<Integer> queue = new ArrayQueue3<>(3);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        Assertions.assertEquals(1, queue.peek());
        Assertions.assertEquals(1, queue.peek());
        Assertions.assertEquals(1, queue.peek());
    }

    @Test
    public void boundary(){
        ArrayQueue3<Integer> queue = new ArrayQueue3<>(5);
        queue.head = 2147483647 - 3;
        queue.tail = queue.head;

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5); // 默认超出 Int 最大值 2147483647 的界限: java.lang.ArrayIndexOutOfBoundsException: -3

        for (Integer value : queue) {
            System.out.println(value);
        }
    }
}
