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
package com.kino.algorithm.b_array;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

/**
 * @author kino
 * @date 2023/3/17 00:49
 */
public class KinoArray implements Iterable<Integer>{
    private int size = 0;  // 逻辑大小
    private int capacity = 10; // 真实容量
    private int[] arr;  // 数组(懒加载初始化)

    /**
     * 按顺序添加一个元素
     * @param element 元素
     */
    public void addLast(int element){
        add(size, element);
    }

    /**
     * 在指定位置插入一个元素
     * @param index 指定位置的下标
     * @param element 元素
     */
    public void add(int index, int element){
        if(null == arr) { //初始化
            arr = new int[capacity];
        }
        expandArr();
        if(index > 0 && index < size) {
            System.arraycopy(arr, index, arr, index + 1, size - index);
        }
        arr[index] = element;
        size++;
    }

    /**
     * 扩容
     */
    private void expandArr() {
        if(size == capacity) {
            capacity += capacity * 1.5;
            int[] newArr = new int[capacity];
            System.arraycopy(arr, 0, newArr, 0, size);
            arr = newArr;
        }
    }

    /**
     * 删除指定位置的记录
     * @param index 索引
     * @return 索引对应的记录值
     */
    public int delete(int index) {
        int deleteElement = -1;
        if(index >= 0 && index < size) { // 可以删除任意位置的元素, 且能保证最终数组连续
            deleteElement = arr[index];
            System.arraycopy(arr, index + 1, arr, index, size - index);
            size--;
        } else {
            System.err.println("下标异常:" + index);
        }
        return deleteElement;
    }

    // 下面均为查询方法

    /**
     * 查询指定位置的值
     * @param index
     * @return
     */
    public int getByIndex(int index) {
        return arr[index];
    }

    /**
     * 使用函数式接口实现 print, 而不是在 for 中直接写死 print
     * @TODO: 几种函数式接口的使用
     * @param consumer
     */
    public void foreach(Consumer<Integer> consumer){
        for (int i = 0; i < size; i++) {
            consumer.accept(arr[i]);
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int i = 0;
            @Override
            public boolean hasNext() { // 判断是否还有下一个元素
                return i < size;
            }

            @Override
            public Integer next() { // 返回当前元素
                return arr[i++];
            }
        };
    }

    public IntStream stream() {
        return IntStream.of(Arrays.copyOfRange(arr, 0, size));
    }
}
