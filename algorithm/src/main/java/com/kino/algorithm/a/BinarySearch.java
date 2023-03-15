package com.kino.algorithm.a;

/**
 * @author kino
 * @date 2023/03/16 01:10
 */
public class BinarySearch {
    /**
     * 二分法(普通写法)
     * @param arr 给定数组
     * @param key 目标值
     * @return 下标
     */
    public static int binarySearch(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (key < arr[mid]) {
                high = mid - 1;
            } else if(arr[mid] < key) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 二分法(普通写法的另一种写法)
     * @param arr 给定数组
     * @param key 目标值
     * @return 下标
     */
    public static int binarySearchPlus(int[] arr, int key) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (key < arr[mid]) {
                high = mid;
            } else if(arr[mid] < key) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 二分法(递归写法)
     * @param arr 给定数组
     * @param key 目标值
     * @param low 左值
     * @param high 右值
     * @return 下标
     */
    public static int binarySearchRecurrence(int[] arr, int low, int high, int key) {
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (key < arr[mid]) {
                return binarySearchRecurrence(arr, low, mid -1, key);
            } else if(arr[mid] < key) {
                return binarySearchRecurrence(arr, low + 1, high, key);
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 将返回值返回的有意义, 比如: 如果 key 不存在, 返回应该插入的下标
     */
    public static int binarySearchResult(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (key < arr[mid]) {
                high = mid - 1;
            } else if(arr[mid] < key) {
                low = mid + 1;
            } else {
                return mid; // found key
            }
        }
        // +1 是为了区分当结果是 0 的时候, 表示这是没找到, 且 key 应该插入到 最前面
        return -(low + 1); // not fount key, result + 1 = insertIndex
    }

    /**
     * key 重复时, 找最左侧的(找不到时返回-1)
     */
    public static int binarySearchLeftMost(int[] arr, int key) {
        int low = 0, high = arr.length;
        int result = -1;
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (key <= arr[mid]) {
                high = mid;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                result = mid;
                high = mid;
            }
        }
        return result;
    }

    /**
     * key 重复时, 找最左侧的(不管找不找得到都返回一个索引, 找不到返回的索引: key可以插入这个索引中; 找得到的索引: key 所在的索引)
     */
    public static int binarySearchLeftMostResult(int[] arr, int key) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (key <= arr[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }
}
