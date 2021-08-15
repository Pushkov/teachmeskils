package com.home.library.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class Reader {
    private final long id;
    private String firstName;
    private String lastName;
    private String email;
    private boolean agreementMailing;
    List<Book> bookList;

    public Reader(long id) {
        this.id = id;
    }

    public Reader(long id, String firstName, String lastName, String email, boolean agreementMailing) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.agreementMailing = agreementMailing;
        bookList = new ArrayList<>();
    }
}
