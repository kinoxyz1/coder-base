package com.kino.algorithm.a_binary;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author kino
 * @date 2023/3/20 10:39
 */
public class LeetCodeTest35 {
    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     *
     * 请必须使用时间复杂度为 O(log n) 的算法。
     *
     * 示例 1:
     * 输入: nums = [1,3,5,6], target = 5
     * 输出: 2
     *
     * 示例2:
     * 输入: nums = [1,3,5,6], target = 2
     * 输出: 1
     *
     * 示例 3:
     * 输入: nums = [1,3,5,6], target = 7
     * 输出: 4
     *
     * 提示:
     * 1 <= nums.length <= 104
     * -104 <= nums[i] <= 104
     * nums 为无重复元素的升序排列数组
     * -104 <= target <= 104
     */

    /**
     * 方法一, 存在的问题:
     *    光看返回值无法确定是数组中有没有对应的key, 可以改写成返回 如果不存在, 返回负数下标.
     */
    public int method1(int[] array, int key){
        int low = 0, high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (key < array[mid]) {
                high = mid -1;
            } else if (array[mid] < key) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return low;
    }

    @Test
    public void test(){
        int[] array = {1, 3, 5, 7, 9, 14};
        assertEquals(0, method1(array, 1));
        assertEquals(1, method1(array, 3));
        assertEquals(2, method1(array, 5));
        assertEquals(3, method1(array, 7));
        assertEquals(4, method1(array, 9));
        assertEquals(5, method1(array, 14));

        assertEquals(0, method1(array, 0));
        assertEquals(3, method1(array, 6));
        assertEquals(6, method1(array, 20));
    }
}
