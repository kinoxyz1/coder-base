package com.kino.algorithm.a;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.kino.algorithm.a.BinarySearch.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBinarySearch {
    @Test
    @DisplayName("found and not found")
    public void find() {
        int[] arr = {2, 5, 8, 10, 23, 54, 78, 99};
        assertEquals(0, binarySearch(arr, 2));
        assertEquals(1, binarySearch(arr, 5));
        assertEquals(2, binarySearch(arr, 8));
        assertEquals(3, binarySearch(arr, 10));
        assertEquals(4, binarySearch(arr, 23));
        assertEquals(5, binarySearch(arr, 54));
        assertEquals(6, binarySearch(arr, 78));
        assertEquals(7, binarySearch(arr, 99));

        assertEquals(-1, binarySearch(arr, 0));
        assertEquals(-1, binarySearch(arr, 15));
        assertEquals(-1, binarySearch(arr, 100));
    }

    @Test
    @DisplayName("findPlus: found and not found")
    public void findPlus() {
        int[] arr = {2, 5, 8, 10, 23, 54, 78, 99};
        assertEquals(0, binarySearchPlus(arr, 2));
        assertEquals(1, binarySearchPlus(arr, 5));
        assertEquals(2, binarySearchPlus(arr, 8));
        assertEquals(3, binarySearchPlus(arr, 10));
        assertEquals(4, binarySearchPlus(arr, 23));
        assertEquals(5, binarySearchPlus(arr, 54));
        assertEquals(6, binarySearchPlus(arr, 78));
        assertEquals(7, binarySearchPlus(arr, 99));

        assertEquals(-1, binarySearchPlus(arr, 0));
        assertEquals(-1, binarySearchPlus(arr, 15));
        assertEquals(-1, binarySearchPlus(arr, 100));
    }

    @Test
    @DisplayName("Recurrence: found and not found")
    public void findRecurrence() {
        int[] arr = {2, 5, 8, 10, 23, 54, 78, 99};

        assertEquals(0, binarySearchRecurrence(arr,  0, arr.length - 1, 2));
        assertEquals(1, binarySearchRecurrence(arr,  0, arr.length - 1, 5));
        assertEquals(2, binarySearchRecurrence(arr,  0, arr.length - 1, 8));
        assertEquals(3, binarySearchRecurrence(arr,  0, arr.length - 1, 10));
        assertEquals(4, binarySearchRecurrence(arr,  0, arr.length - 1, 23));
        assertEquals(5, binarySearchRecurrence(arr,  0, arr.length - 1, 54));
        assertEquals(6, binarySearchRecurrence(arr,  0, arr.length - 1, 78));
        assertEquals(7, binarySearchRecurrence(arr,  0, arr.length - 1, 99));

        assertEquals(-1, binarySearchRecurrence(arr, 0, arr.length - 1,  0));
        assertEquals(-1, binarySearchRecurrence(arr, 0, arr.length - 1,  15));
        assertEquals(-1, binarySearchRecurrence(arr, 0, arr.length - 1,  100));
    }

    @Test
    @DisplayName("Result: 将不存在的 key 插入到数组中")
    public void findRecurrenceResult() {
        int[] arr = {2, 5, 8, 10, 23, 54, 78, 99};
        System.out.println("原数组:\t\t" + Arrays.toString(arr));

        int resultIndex = binarySearchResult(arr,0);
        int[] newArr = new int[arr.length + 1];
        newArr[resultIndex+1] = 0;
        System.arraycopy(arr, 0, newArr, 1, arr.length);
        System.out.println("左边没有:\t" + Arrays.toString(newArr));

        resultIndex = binarySearchResult(arr,15);
        newArr = new int[arr.length + 1];
        System.arraycopy(arr, 0, newArr, 0, Math.abs(resultIndex+1));
        newArr[Math.abs(resultIndex+1)] = 15;
        System.arraycopy(arr, Math.abs(resultIndex+1), newArr, Math.abs(resultIndex), arr.length - Math.abs(resultIndex+1));
        System.out.println("中间没有:\t" + Arrays.toString(newArr));

        resultIndex = binarySearchResult(arr,100);
        newArr = new int[arr.length + 1];
        System.arraycopy(arr, 0, newArr, 0, Math.abs(resultIndex+1));
        newArr[Math.abs(resultIndex+1)] = 100;
        System.out.println("右边没有:\t" + Arrays.toString(newArr));
    }

    @Test
    @DisplayName("LeftMost: found and not found")
    public void findLeftMost() {
        int[] arr = {2, 5, 8, 10, 10, 10, 23, 54, 78, 99};
        System.out.println(binarySearchLeftMost(arr, 12));
        System.out.println(binarySearchLeftMostResult(arr, 12));
    }
}
