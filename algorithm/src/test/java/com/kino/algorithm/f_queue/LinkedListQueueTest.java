package com.kino.algorithm.f_queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author kino
 * @date 2023/5/2 21:03
 */
public class LinkedListQueueTest {

    @Test
    public void offerLimit(){
        LinkedListQueue<Integer> queue = new LinkedListQueue<>(3);
        Assertions.assertTrue(queue.offer(1));
        Assertions.assertTrue(queue.offer(2));
        Assertions.assertTrue(queue.offer(3));
        Assertions.assertFalse(queue.offer(4));
        for (Integer val : queue) {
            System.out.println(val);
        }
    }
    @Test
    public void offer(){
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        for (Integer val : queue) {
            System.out.println(val);
        }
    }

    @Test
    public void poll(){
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }

    @Test
    public void peek(){
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        queue.offer(1);
        System.out.println(queue.peek());
        queue.offer(2);
        System.out.println(queue.peek());
        queue.offer(3);
        System.out.println(queue.peek());

    }
}
