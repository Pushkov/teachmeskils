package com.home.model;

public class Person {
    private static int age = 10;

    static {
        System.out.println("s- " + age);
    }

    {
        System.out.println(age++);
    }
}
