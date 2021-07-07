package com.home.model;

import com.home.constant.Sex;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Person {

    private String name;
    private Integer age;
    private Sex sex;
    private String country;
    private String city;
}
