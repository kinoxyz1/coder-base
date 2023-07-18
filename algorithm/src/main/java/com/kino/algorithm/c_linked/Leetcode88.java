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
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
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

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        nums2 = new int[nums1.length];
        recursion(nums1, 0, m-1, m, n+m-1, nums2, 0);
        System.arraycopy(nums2, 0, nums1, 0, nums2.length);
    }

    /**
     * 递归函数
     * @param nums1 将两个有序数组合并后的数组
     * @param i 前一个有序数组的起始位置
     * @param iEnd 前一个有序数组的结束位置
     * @param j 后一个有序数组的起始位置
     * @param jEnd 后一个有序数组的结束位置
     * @param nums2 新数组
     * @param k 新数组的下标
     */
    public static void recursion(int[] nums1, int i, int iEnd, int j, int jEnd, int[] nums2, int k){
        if (i > iEnd) {
            System.arraycopy(nums1, j, nums2, k, jEnd - j + 1);
            return;
        }
        if (j > jEnd) {
            System.arraycopy(nums1, i, nums2, k, iEnd - i + 1);
            return;
        }
        if (nums1[i] < nums1[j]) {
            nums2[k] = nums1[i];
            recursion(nums1, ++i, iEnd, j, jEnd, nums2, ++k);
        } else {
            nums2[k] = nums1[j];
            recursion(nums1, i, iEnd, ++j, jEnd, nums2, ++k);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{0};
        int[] nums2 = new int[]{1};
        merge(nums1, 0, nums2, 1);
        System.out.println(Arrays.toString(nums1));
    }
}
