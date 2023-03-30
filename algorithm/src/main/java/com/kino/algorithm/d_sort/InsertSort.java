package com.kino.algorithm.d_sort;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @author kino
 * @date 2023/3/30 21:45
 */
public class InsertSort {

    /**
     * 往后移版本
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
                }
            }
            if (changeIndex != -1) {
                array[changeIndex] = compare;
            }
            bound++;
        }
    }

    /**
     * 交换顺序版本
     * @param array
     */
    public static void sort2(int[] array) {

    }

    /**
     * 递归版本
     * @param array
     */
    public static void sort3(int[] array) {

    }

    /**
     * 二分法版本
     * @param array
     */
    public static void sort4(int[] array) {

    }

    public static void main(String[] args) {
        int[] array = {65, 232, 65, 23, 674, 367, 136, 2, 54, 64, 309, 92};
        sort1(array);
        System.out.println(Arrays.toString(array));
    }
}
