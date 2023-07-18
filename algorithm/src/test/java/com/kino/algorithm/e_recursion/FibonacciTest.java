/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
