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

package com.kino.algorithm.c_linked;

import java.util.Arrays;

/**
 * 合并两个有序数组: https://leetcode.cn/problems/merge-sorted-array/
 *
 * @author kino
 * @date 2023/5/1 22:58
 */
public class Leetcode88 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int point = 0;
        for (int i = 0; i < n; i++) {
            if (point == m) {
                System.arraycopy(nums2, i, nums1, point, n);
                break; // nums1 被比较完了
            }

            while (point < m) {
                if (nums2[i] >= nums1[point]) {
                    ++point;
                } else break;
            }

            System.arraycopy(nums1, point, nums1, point + 1, m - point);
            nums1[point] = nums2[i];
            ++m;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
