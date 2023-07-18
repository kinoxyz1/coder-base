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

import java.util.Iterator;

/**
 * 环形队列实现队列:
 * 该方法需要预留一个空位给 tail 指针, 如果不预留一个空位, 在最后一个位置被写入记录后, tail 会和 head 相等, 就无法判断是空还是满了.
 *
 * @author kino
 * @date 2023/5/2 22:09
 */
public class ArrayQueue1<E> implements Queue<E>, Iterable<E> {
    private final E[] element; // 数组
    private int head = 0; // 头指针
    private int tail = 0; // 尾指针

    @SuppressWarnings("all")
    public ArrayQueue1(int capacity) { // 初始化数组大小
        element = (E[]) new Object[capacity + 1];
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) return false;
        element[tail] = value;
        tail = (tail + 1) % element.length;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) return null;
        E value = element[head];
        head = (head + 1) % element.length;
        return value;
    }

    @Override
    public E peek() {
        if (isEmpty()) return null;
        return element[head];
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        return (tail + 1) % element.length == head;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int point = 0;

            @Override
            public boolean hasNext() {
                return point != tail;
            }

            @Override
            public E next() {
                E value = element[point];
                point = (point + 1) % element.length;
                return value;
            }
        };
    }
}
