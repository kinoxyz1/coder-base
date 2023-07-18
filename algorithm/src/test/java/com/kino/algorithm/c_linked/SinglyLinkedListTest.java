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
package com.kino.algorithm.c_linked;

import org.junit.jupiter.api.Test;

/**
 * @author kino
 * @date 2023/3/21 00:49
 */
public class SinglyLinkedListTest {
    @Test
    public void test() throws IllegalAccessException {
        SinglyLinkedList list = new SinglyLinkedList();

        list.addLast(4);
        list.addLast(5);
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        list.addLast(6);

        list.loop1(System.out::println);
//        list.loop2(System.out::println);
//        for (Integer value : list) {
//            System.out.println(value);
//        }

        System.out.println("=====");
        System.out.println(list.getValue(0));
        System.out.println(list.getValue(1));
        System.out.println(list.getValue(2));
        System.out.println(list.getValue(3));
        System.out.println(list.getValue(4));
        System.out.println(list.getValue(5));
        System.out.println(list.getValue(6));
    }
}
