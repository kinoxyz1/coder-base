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

package com.kino.algorithm.a_binary;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author kino
 * @date 2023/3/20 14:52
 */
public class LeetCodeTest34 {
    /**
     * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
     * 如果数组中不存在目标值 target，返回[-1, -1]。
     * 你必须设计并实现时间复杂度为O(log n)的算法解决此问题。
     * <p>
     * 示例 1：
     * 输入：nums = [5,7,7,8,8,10], target = 8
     * 输出：[3,4]
     * <p>
     * 示例2：
     * 输入：nums = [5,7,7,8,8,10], target = 6
     * 输出：[-1,-1]
     * <p>
     * 示例 3：
     * 输入：nums = [], target = 0
     * 输出：[-1,-1]
     * <p>
     * 提示：
     * 0 <= nums.length <= 105
     * -109<= nums[i]<= 109
     * nums是一个非递减数组
     * -109<= target<= 109
     */
    public int[] method(int[] array, int key) {
        // 先判空
        int left = -1, right = -1;
        if (array == null || array.length == 0) {
            return new int[]{left, right};
        } else {
            left = leftIndex(array, key);
            if (left == -1) return new int[]{left, right};
            else right = rightIndex(array, key);
            return new int[]{left, right};
        }
    }

    private static int leftIndex(int[] array, int key) {
        // 左值
        int low = 0, high = array.length - 1;
        int result = -1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (key < array[mid]) {
                high = mid - 1;
            } else if(array[mid] < key) {
                low = mid + 1;
            } else {
                result = mid;
                high = mid - 1;
            }
        }
        return result;
    }

    private static int rightIndex(int[] array, int key) {
        // 左值
        int low = 0, high = array.length - 1;
        int result = -1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (key < array[mid]) {
                high = mid - 1;
            } else if(array[mid] < key) {
                low = mid + 1;
            } else {
                result = mid;
                low = mid + 1;
            }
        }
        return result;
    }

    @Test
    public void test() {
        int[] array = {1, 3, 5, 5, 7, 7, 7, 9, 12, 12, 12, 12, 19, 19, 20};
        Assertions.assertArrayEquals(new int[]{2, 3}, method(array, 5));
        Assertions.assertArrayEquals(new int[]{4, 6}, method(array, 7));
        Assertions.assertArrayEquals(new int[]{8, 11}, method(array, 12));
        Assertions.assertArrayEquals(new int[]{-1, -1}, method(array, 0));
        Assertions.assertArrayEquals(new int[]{-1, -1}, method(array, 18));
        Assertions.assertArrayEquals(new int[]{-1, -1}, method(array, 30));
    }
}
