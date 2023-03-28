package com.kino.algorithm.d_sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author kino
 * @date 2023/3/27 21:35
 */
public class BubbleSortTest {
    @Test
    public void test1() {
        int[] array = {12,1,5,2,9,6};
        System.out.println(Arrays.toString(BubbleSort.bubbleSort1(array)));

        System.out.println(Arrays.toString(BubbleSort.bubbleSort2(array, array.length-1)));

        System.out.println(Arrays.toString(BubbleSort.bubbleSort3(array, array.length-1)));


    }
}
