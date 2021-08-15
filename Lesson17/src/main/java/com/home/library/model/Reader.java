package com.home.library.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Reader {
    private final long id;
    private String firstName;
    private String lastName;
    private EmailAddress address;
    private boolean agreementMailing;
    List<Book> bookList;

    public Reader(long id) {
        this.id = id;
    }

    public Reader(long id, String firstName, String lastName, EmailAddress address, boolean agreementMailing) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.agreementMailing = agreementMailing;
        bookList = new ArrayList<>();
    }
}
