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
package com.kino.algorithm.d_sort;

/**
 * 冒泡排序
 *
 * @author kino
 * @date 2023/3/27 21:32
 */
public class BubbleSort {

    /**
     * 写法一: 普通方法
     * 双层for:
     * 外层 for 控制循环次数
     * 内层 for 控制元素和后一个元素相比较
     *
     * @param array
     * @return
     */
    public static int[] bubbleSort1(int[] array) {
        for (int i = 0; i < array.length; i++) { // 控制循环次数
            for (int j = 0; j < array.length - 1; j++) {  // 比较
                if (array[j] > array[j + 1]) {  // 条件成立交换位置
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        return array;
    }

    /**
     * 写法二: 递归实现
     *
     * @param array 数组
     * @param right 需要比较的数据的右边界
     * @return 数组
     */
    public static int[] bubbleSort2(int[] array, int right) {
        if (right == 0) {
            return array;
        }
        for (int i = 0; i < right; i++) {
            if (array[i] > array[i + 1]) {
                int tmp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = tmp;
            }
        }
        bubbleSort2(array, --right);
        return array;
    }

    /**
     * 写法三: 递归实现 plus
     * 在写法二中, 如果数组前面几个元素已经是有序的, 那不管怎么样也会再去比较一次, 这里对这部分进行改进.
     *
     * @param array
     * @param right
     * @return
     */
    public static int[] bubbleSort3(int[] array, int right) {
        if (right == 0) {
            return array;
        }
        int sign = 0; // 打记号, 如果发生了交换, 就把被交换记录的index给sign用于下一次递归
        for (int i = 0; i < right; i++) {
            if (array[i] > array[i + 1]) {
                int tmp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = tmp;
                sign = i;
            }
        }
        bubbleSort3(array, sign);
        return array;
    }
}
