package com.home.library.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class EmailAddress {
    private final String email;
    private final String message;
}
