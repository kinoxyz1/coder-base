package com.kino.algorithm.a;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author kino
 * @date 2023/3/17 14:21
 */
public class LeetCodeTest704 {
    /**
     * 给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
     *
     *
     * 示例 1:
     *
     * 输入: nums = [-1,0,3,5,9,12], target = 9
     * 输出: 4
     * 解释: 9 出现在 nums 中并且下标为 4
     * 示例2:
     *
     * 输入: nums = [-1,0,3,5,9,12], target = 2
     * 输出: -1
     * 解释: 2 不存在 nums 中因此返回 -1
     *
     *
     * 提示：
     *
     * 你可以假设 nums中的所有元素是不重复的。
     * n将在[1, 10000]之间。
     * nums的每个元素都将在[-9999, 9999]之间。
     */

    /**
     * 方式一: 基础二分法
     */
    private int method1(int[] array, int key) {
        int low = 0, high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (key < array[mid]) {
                high = mid - 1;
            } else if (array[mid] < key) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 方式二: 可以查找有序可重复的array, 并且能找到 重复元素中最左侧 的那个元素的下标, 找不到的话返回 -1.
     */
    private int method2(int[] array, int key) {
        int low = 0, high = array.length;
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (key <= array[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return high <= array.length - 1 && array[high] == key ? high : -1;
    }

    /**
     * 方式三: 可以查找有序可重复的array, 并且能找到 重复元素中最右侧 的那个元素的下标, 找不到返回 -1.
     *   但是不能像 method2 那样 return, 这里需要添加一个中间变量存储最终的结果才可以.
     * @param array
     * @param key
     * @return
     */
    private int method3(int[] array, int key) {
        int low = 0, high = array.length;
        int result = -1;
        while (low < high) {
            int mid = (low + high) >>> 1;
            if(array[mid] < key) {
                low = mid + 1;
            } else if (key < array[mid]) {
                high = mid;
            } else {
                result = mid;
                low = mid + 1;
            }
        }
        return result;
    }

    @Test
    public void test() {
        int[] array = {1, 3, 5, 7, 9, 15};
        assertEquals(0, method1(array, 1));
        assertEquals(1, method1(array, 3));
        assertEquals(2, method1(array, 5));
        assertEquals(3, method1(array, 7));
        assertEquals(4, method1(array, 9));
        assertEquals(5, method1(array, 15));
        assertEquals(-1, method1(array, 0));
        assertEquals(-1, method1(array, 2));
        assertEquals(-1, method1(array, 20));

        assertEquals(0, method2(array, 1));
        assertEquals(1, method2(array, 3));
        assertEquals(2, method2(array, 5));
        assertEquals(3, method2(array, 7));
        assertEquals(4, method2(array, 9));
        assertEquals(5, method2(array, 15));
        assertEquals(-1, method2(array, 0));
        assertEquals(-1, method2(array, 2));
        assertEquals(-1, method2(array, 20));

        assertEquals(0, method3(array, 1));
        assertEquals(1, method3(array, 3));
        assertEquals(2, method3(array, 5));
        assertEquals(3, method3(array, 7));
        assertEquals(4, method3(array, 9));
        assertEquals(5, method3(array, 15));
        assertEquals(-1, method3(array, 0));
        assertEquals(-1, method3(array, 2));
        assertEquals(-1, method3(array, 20));
    }
}
