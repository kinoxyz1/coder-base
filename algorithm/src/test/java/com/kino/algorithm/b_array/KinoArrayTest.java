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
