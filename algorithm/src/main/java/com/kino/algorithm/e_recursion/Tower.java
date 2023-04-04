package com.kino.algorithm.e_recursion;

// import org.springframework.util.StopWatch;

import org.springframework.util.StopWatch;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 汉诺塔
 * 有三根杆子A、B、C，其中A杆上有n个大小不等的圆盘，现在要将所有的圆盘从A杆移到C杆，但是必须满足以下条件：
 * 1.每次只能移动一个圆盘；
 * 2.大盘子不能放在小盘子上面。
 * 请问，最少需要移动多少次，才能完成这个任务？
 * <p>
 * 层数    步骤
 * 1      (A->C)
 * 2      (A->B, A->C, B->C)
 * 3      (A->C, A->B, C->B, A->C, B->A, b->C, A->C)
 * 4      ()
 *
 * @author kino
 * @date 2023/4/3 18:12
 */
public class Tower {
    private static LinkedList<Integer> A = new LinkedList<>();
    private static LinkedList<Integer> B = new LinkedList<>();
    private static LinkedList<Integer> C = new LinkedList<>();

    private static void init(int n) {
        for (int i = n; i >= 1; i--) {
            A.addLast(i);
        }
    }

    public static void tower(int n, LinkedList<Integer> A, LinkedList<Integer> B, LinkedList<Integer> C) {
        if (n == 0) {
            return;
        } else {
            tower(n - 1, A, C, B);
            C.addLast(A.removeLast());  // A 的最后一个移动到C的第一个
            print();
            tower(n - 1, B, A, C);
        }
    }

    public static void main(String[] args) {
        init(3);
        print();
        tower(3, A, B, C);
    }

    private static void print() {
        System.out.println("------------");
        System.out.println(Arrays.toString(A.toArray()));
        System.out.println(Arrays.toString(B.toArray()));
        System.out.println(Arrays.toString(C.toArray()));
    }
}

