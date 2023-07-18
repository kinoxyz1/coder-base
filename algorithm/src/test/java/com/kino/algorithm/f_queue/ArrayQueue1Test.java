/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.kino.algorithm.f_queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author kino
 * @date 2023/5/2 22:16
 */
public class ArrayQueue1Test {
    @Test
    public void offer(){
        ArrayQueue1<Integer> queue = new ArrayQueue1<>(3);
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
        ArrayQueue1<Integer> queue = new ArrayQueue1<>(3);
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
        ArrayQueue1<Integer> queue = new ArrayQueue1<>(3);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        Assertions.assertEquals(1, queue.peek());
        Assertions.assertEquals(1, queue.peek());
        Assertions.assertEquals(1, queue.peek());
    }
}
