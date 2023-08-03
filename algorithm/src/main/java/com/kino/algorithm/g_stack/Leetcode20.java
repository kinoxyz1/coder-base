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
package com.kino.algorithm.g_stack;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/valid-parentheses/
 * @author kino
 * @date 2023/8/4 12:33 AM
 */
public class Leetcode20 {

    public boolean isValid(String s) {
        Character[] array = new Character[s.length()];
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') array[index++] = ')';
            else if (c == '{') array[index++] = '}';
            else if (c == '[') array[index++] = ']';
            else {
                if (index == 0 || array[--index] != c){
                    return false;
                }
            }
        }
        return index == 0;
    }

    public static void main(String[] args) {
        Leetcode20 leetcode20 = new Leetcode20();
        boolean valid1 = leetcode20.isValid("({})");
        boolean valid2 = leetcode20.isValid("({[]})");
        boolean valid3 = leetcode20.isValid("(}");
        boolean valid4 = leetcode20.isValid("{})");
        boolean valid5 = leetcode20.isValid("[({})");
        System.out.println(valid1);
        System.out.println(valid2);
        System.out.println(valid3);
        System.out.println(valid4);
        System.out.println(valid5);
    }

}
