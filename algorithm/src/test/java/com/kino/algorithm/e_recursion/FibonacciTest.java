package com.kino.algorithm.e_recursion;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author kino
 * @date 2023/4/3 16:09
 */
public class FibonacciTest {

    @Test
    public void test1() {
        System.out.println(Arrays.toString(Fibonacci.fibonacci1(40)));
    }

    @Test
    public void test2() {
        System.out.println(Fibonacci.fibonacci2(4));
    }

    @Test
    public void test3() {
        System.out.println(Fibonacci.fibonacci3(40));
    }

    @Test
    public void test4() {
        System.out.println(Fibonacci.fibonacciRabbit(40));
    }

    @Test
    public void test5() {
        System.out.println(Fibonacci.fibonacciFrog(39));
    }
}
