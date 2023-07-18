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
 * 环形队列实现队列: 该方法不空位置, 也不额外加属性, 通过 head 和 tail 判断满和空
 *
 * @author kino
 * @date 2023/5/3 23:03
 */
public class ArrayQueue3<E> implements Queue<E>, Iterable<E> {

    private final E[] element;
    int head;
    int tail;

    @SuppressWarnings("all")
    public ArrayQueue3(int capacity) {
        // 为测试用例中的 boundary 方法改动, 避免超出 int 范围报错
        int n = capacity - 1;
        n |= n >> 1;
        n |= n >> 2;
        n |= n >> 4;
        n |= n >> 8;
        n |= n >> 16;
        element = (E[]) new Object[n + 1];
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) return false;
        // element[tail & element.length] = value;
        element[tail & (element.length - 1)] = value; // 为测试用例中的 boundary 方法改动, 避免超出 int 范围报错
        tail++;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) return null;
        // E value = element[head % element.length];
        E value = element[head & (element.length - 1)]; // 为测试用例中的 boundary 方法改动, 避免超出 int 范围报错
        head++;
        return value;
    }

    @Override
    public E peek() {
        if (isEmpty()) return null;
        // return element[head % element.length];
        return element[head & (element.length - 1)]; // 为测试用例中的 boundary 方法改动, 避免超出 int 范围报错
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        // return tail % element.length == head % element.length;
        return tail - head == element.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int point = head;

            @Override
            public boolean hasNext() {
                return point != tail;
            }

            @Override
            public E next() {
                // E value = element[point % element.length];
                E value = element[point & (element.length - 1)]; // 为测试用例中的 boundary 方法改动, 避免超出 int 范围报错
                point++;
                return value;
            }
        };
    }
}
