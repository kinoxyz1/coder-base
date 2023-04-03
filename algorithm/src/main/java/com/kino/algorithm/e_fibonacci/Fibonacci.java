package com.kino.algorithm.e_fibonacci;

import java.util.Arrays;

/**
 * @author kino
 * @date 2023/4/3 15:57
 */
public class Fibonacci {
    /**
     * 斐波那契是一个数列，这个数列的前两个数是0和1，从第三项开始，每一项都等于前两项之和。
     * 因此，这个数列的前几项是：0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144，依此类推。
     */

    public static long[] fibonacci1(int n) {
        long[] arr = new long[n];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr;
    }

    /**
     * 递归求第n项的值
     *
     * @param n
     * @return
     */
    public static long fibonacci2(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        long x = fibonacci2(n - 1);
        long y = fibonacci2(n - 2);
        return x + y;
    }

    /**
     * 记忆法
     * 使用记忆法（Memoization）的优点在于可以缓存已经计算过的结果，避免重复计算，从而提高程序的性能。
     *  使用记忆法的斐波那契数列实现的时间复杂度为O(n)，而不使用记忆法的递归实现的时间复杂度为O(2^n)，
     *  因此在n较大的情况下，使用记忆法可以大大缩短程序的运行时间。
     *
     * 另一方面，使用记忆法需要占用额外的存储空间来存储已经计算过的结果，
     *  因此在空间有限的情况下，使用记忆法可能会导致内存占用过高。
     *  而不使用记忆法的递归实现则不需要额外的存储空间，但是由于存在重复计算，时间复杂度较高，
     *  可能导致程序运行速度缓慢。
     *
     * 在测试用例上, 取 第排在第40位的结果, 未使用记忆法耗时: 261ms, 使用记忆法耗时: 1ms
     * @param n
     * @return
     */
    public static long fibonacci3(int n) {
        long[] arr = new long[n+1];
        Arrays.fill(arr, -1);
        arr[0] = 0;
        arr[1] = 1;
        return fibonacciMemory(n, arr);
    }
    private static long fibonacciMemory(int n, long[] arr){
        if(arr[n] != -1){
            return arr[n];
        }
        arr[n] = fibonacciMemory(n - 1, arr) + fibonacciMemory(n - 2, arr);
        return arr[n];
    }
}
