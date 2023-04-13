package com.kino.algorithm.e_recursion;

/**
 * 杨辉三角形: 也称帕斯卡三角形，是一种数学图形，它是由数字排列成三角形的形式，其中每个数字是上面两个数字的和。
 * 1
 * 1   1
 * 1   2   1
 * 1   3   3   1
 * 1   4   6   4   1
 * 1   5   10  10  5   1
 * 1   6   15  20  15  6   1
 * 1   7   21  35  35  21  7   1
 * 1   8   28  56  70  56  28  8   1
 * 1   9   36  84  126 126 84  36  9   1
 * @author kino
 * @date 2023/4/4 16:15
 */
public class PascalTriangle {
    /**
     * 方式一
     * @param n 杨辉三角形层数
     */
    public static void triangle1(int n){
        int[][] array = new int[n][n];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j <= i; j++) {
                if(j == 0 || j == i){
                    array[i][j] = 1;
                } else {
                    array[i][j] = array[i-1][j-1] + array[i-1][j];
                }
            }
        }
        // print
        for (int[] arr : array) {
            for (int value : arr) {
                if(value!=0){
                    System.out.print(value+"\t");
                }
            }
            System.out.println();
        }
    }

    /**
     * 方式二: 递归
     * @param i
     * @param j
     * @return
     */
    public static int triangle2(int i, int j){
        // 一行的第一个和最后一个取值为1
        if(j == 0 || i == j){
            return 1;
        }
        return triangle2(i -1, j - 1) + triangle2(i - 1, j);
    }

    public static void main(String[] args) {
        int count = 10;
        for (int i = 0; i < count; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.printf("%-4d", triangle2(i, j));
            }
            System.out.println();
        }
    }
}
