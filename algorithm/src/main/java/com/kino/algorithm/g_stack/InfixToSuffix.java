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
 * 中缀转后缀
 * @author kino
 * @date 2023/8/4 1:39 AM
 */
public class InfixToSuffix {

    /**
     * a+b          ab+
     * a+b-c        ab+c-
     * a*b-c        ab*c-
     * a+b*c        abc*+
     * a+b*c-d      abc*+d-
     * (a+b)*c
     */

    static int weight(Character input){
        switch (input) {
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
            case '(':
                return 0;
            default:
                throw new IllegalArgumentException("非法的运算符: " + input);
        }
    }

    static String infixToSuffix(String exp){
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            switch (c) {
                case '+':
                case '-':
                case '*':
                case '/':
                    if (stack.isEmpty()) {
                        stack.push(c);
                    } else {
                        if (weight(c) > weight(stack.peek())) {
                            stack.push(c);
                        } else {
                            while (!stack.isEmpty() && weight(stack.peek()) >= weight(c)) {
                                sb.append(stack.pop());
                            }
                            stack.push(c);
                        }
                    }
                    break;
                case '(':
                    stack.push('(');
                    break;
                case ')':
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.pop();
                    break;
                default:
                    sb.append(c);
                    break;
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(infixToSuffix("a+b"));
        System.out.println(infixToSuffix("a+b-c"));
        System.out.println(infixToSuffix("a+b*c"));
        System.out.println(infixToSuffix("a*b-c"));
        System.out.println(infixToSuffix("(a+b)*c"));
        System.out.println(infixToSuffix("(a+b*c-d)*e"));
        System.out.println(infixToSuffix("a*(b+c)"));
    }

}
