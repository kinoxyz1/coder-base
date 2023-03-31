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

    }

    public static void main(String[] args) {
        int[] array = {232, 61, 65, 23, 674, 367, 136, 2, 54, 64, 309, 92};
        // sort4(array);
        // sort2(array);
        sort3(array);
        System.out.println(Arrays.toString(array));
    }
}
