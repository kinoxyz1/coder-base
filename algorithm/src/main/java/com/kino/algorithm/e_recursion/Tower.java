package com.kino.algorithm.e_recursion;

/**
 * 汉诺塔
 * 有三根杆子A、B、C，其中A杆上有n个大小不等的圆盘，现在要将所有的圆盘从A杆移到C杆，但是必须满足以下条件：
 * 1.每次只能移动一个圆盘；
 * 2.大盘子不能放在小盘子上面。
 * 请问，最少需要移动多少次，才能完成这个任务？
 *
 * 层数    步骤
 * 1      (A->C)
 * 2      (A->B, A->C, B->C)
 * 3      (A->C, A->B, C->B, A->C, B->A, b->C, A->C)
 * 4      ()
 * @author kino
 * @date 2023/4/3 18:12
 */
public class Tower {
    public static void tower(int n){

    }
}
