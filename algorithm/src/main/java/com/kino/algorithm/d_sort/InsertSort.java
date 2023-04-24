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

import java.util.Arrays;

import static com.kino.algorithm.a_binary.BinarySearch.binarySearchRecurrence;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 插入排序
 *
 * @author kino
 * @date 2023/3/30 21:45
 */
public class InsertSort {

    /**
     * 往后移版本
     *
     * @param array
     */
    public static void sort1(int[] array) {
        if (null == array || array.length == 1) {
            return;
        }
        // 默认边界, 以 bound 为界限将 数组 分为有序和无序两种情况
        // array - (array - bound) = 有序
        // array - bound = 无序
        int bound = 1;
        for (int i = bound; i < array.length; i++) { // 外层for遍历所有无序元素
            // 内层for取 第一个无序元素 和所有有序元素相比较, 如果可以, 则交换位置
            int changeIndex = -1; // 记录最后发生移动元素的index
            int compare = array[i]; // 第一个无序元素
            for (int j = bound - 1; j >= 0; j--) {
                if (compare < array[j]) { // 无序元素比前一个元素小, 则将前一个元素后移
                    array[j + 1] = array[j];
                    changeIndex = j;
                    // 考虑有重复元素,所以没有直接break;
                }
            }
            if (changeIndex != -1) {
                array[changeIndex] = compare;
            }
            bound++;
        }
    }

    /**
     * 递归版本
     *
     * @param array
     */
    public static void sort2(int[] array) {
        sort2(array, 1);
    }

    /**
     * @param array 数组
     * @param bound 界限, 将数组分为已排序和未排序两部分, bound 是未排序的第一个元素
     */
    private static void sort2(int[] array, int bound) {
        if (array == null || array.length < 2 || bound == array.length) {
            return;
        }
        int compare = array[bound]; // 无序中代比较的第一个元素
        int index = bound - 1; // 有序的最后一个元素下标
        while (index >= 0 && compare < array[index]) {
            array[index + 1] = array[index];
            index--;
        }
        if (index + 1 != bound) {
            array[index + 1] = compare;
        }
        sort2(array, ++bound);
    }

    /**
     * 二分法版本
     *
     * @param array
     */
    public static void sort3(int[] array) {
        if (null == array || array.length < 2) return;
        if(array[1] < array[0]){
            int tmp = array[1];
            array[1] = array[0];
            array[0] = tmp;
        }
        int bound = 2; // 边界
        for (int i = bound; i < array.length; i++) {
            int[] ints = new int[bound];
            System.arraycopy(array, 0, ints, 0, bound);
            int index = binary(ints, 0, bound - 1, array[bound]);
            if(index < 0){
                int tmp = array[bound];
                int remove = Math.abs(index) - 1;
                System.arraycopy(array, remove, array, remove + 1, ints.length - remove);
                array[Math.abs(index) - 1] = tmp;
            } else if(index == 0) {
                System.arraycopy(array, 0, array,  1, ints.length);
            }
            bound++;
        }
    }

    /**
     * 递归实现二分法
     * @param array 数组
     * @param left 左边界
     * @param right 有边界
     * @param key 目标值
     * @return 如果找到了, 返回的是目标值的下标, 如果没找到, Math.abs(return) - 1 => 可以在该 index 的位置插入记录.
     */
    private static int binary(int[] array, int left, int right, int key) {
        if (null == array || array.length < 2) return -1;
        if (right < left) return -(left+1);
        int mid = (right + left) >> 1;
        if (key < array[mid]) {
            return binary(array, left, mid - 1, key);
        } else if (array[mid] < key) {
            return binary(array, mid+1, right, key);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        int[] array = {232, 61, 65, 23, 674, 367, 136, 23, 2, 54, 64, 309, 92};
        // // sort4(array);
        // // sort2(array);
        sort3(array);
        System.out.println(Arrays.toString(array));

        // int[] arr = {2, 5, 8, 10, 23, 54, 78, 99};
        //
        // System.out.println(binary(arr, 0, arr.length - 1, 1));
        // System.out.println(binary(arr, 0, arr.length - 1, 2));
        // System.out.println(binary(arr, 0, arr.length - 1, 5));
        // System.out.println(binary(arr, 0, arr.length - 1, 8));
        // System.out.println(binary(arr, 0, arr.length - 1, 10));
        // System.out.println(binary(arr, 0, arr.length - 1, 23));
        // System.out.println(binary(arr, 0, arr.length - 1, 54));
        // System.out.println(binary(arr, 0, arr.length - 1, 78));
        // System.out.println(binary(arr, 0, arr.length - 1, 99));
        // System.out.println(binary(arr, 0, arr.length - 1, 100));
    }
}
