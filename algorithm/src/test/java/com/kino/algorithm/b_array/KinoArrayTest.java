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
package com.kino.algorithm.b_array;

import org.junit.jupiter.api.Test;

/**
 * @author kino
 * @date 2023/3/17 00:55
 */
public class KinoArrayTest {
    @Test
    public void test1(){
        KinoArray kinoArray = new KinoArray();
        kinoArray.addLast(1);
        kinoArray.addLast(2);
        kinoArray.addLast(3);
        kinoArray.addLast(4);
        kinoArray.addLast(5);
        kinoArray.add(3, 10);

        System.out.println("delete: "+kinoArray.delete(6));

        System.out.println(kinoArray.getByIndex(1));
        System.out.println("===============");

        kinoArray.foreach(element -> {
            System.out.println(element);
        });
        System.out.println("===============");

        for (Integer element : kinoArray) {
            System.out.println(element);
        }
        System.out.println("===============");

        kinoArray.stream().forEach(element -> {
            System.out.println(element);
        });
    }
}
