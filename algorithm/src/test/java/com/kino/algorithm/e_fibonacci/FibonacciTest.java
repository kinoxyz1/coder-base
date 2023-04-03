package com.kino.algorithm.e_fibonacci;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
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
        System.out.println(Fibonacci.fibonacci2(39));
    }

    @Test
    public void test3() {
        System.out.println(Fibonacci.fibonacci3(39));
    }
}
