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
     *   双层for:
     *     外层 for 控制循环次数
     *     内层 for 控制元素和后一个元素相比较
     *
     * @param array
     * @return
     */
    public static int[] BubbleSort1(int[] array) {
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
    public static int[] BubbleSort2(int[] array, int right) {
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
        BubbleSort2(array, --right);
        return array;
    }
}
