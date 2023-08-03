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
package com.kino.algorithm.g_stack;

import java.util.Iterator;

/**
 * 数组实现栈
 * @author kino
 * @date 2023/8/4 12:04 AM
 */
public class ArrayStack<E> implements Stack<E>, Iterable<E>{
    private E[] array;
    private int point = 0; // 记录点位

    public ArrayStack(int capacity) {
        array = (E[]) new Object[capacity];
    }

    @Override
    public boolean push(E value) {
        if (isFull()) return false;
        array[point++] = value;
        return true;
    }

    @Override
    public E pop() {
        if (isEmpty()) return null;
        return array[--point];
    }

    @Override
    public E peek() {
        if (isEmpty()) return null;
        return array[point-1];
    }

    @Override
    public boolean isEmpty() {
        return point == 0;
    }

    @Override
    public boolean isFull() {
        return array.length == point;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p = array.length;
            @Override
            public boolean hasNext() {
                return p != 0;
            }

            @Override
            public E next() {
                return array[--p];
            }
        };
    }
}
