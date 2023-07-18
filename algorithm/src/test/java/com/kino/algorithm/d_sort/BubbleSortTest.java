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
