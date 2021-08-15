package com.home.library.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {
    private final int id;
    private String authorName;
    private String authorSurname;
    private String authorPatronymic;
    private String name;
    private Reader owner;
    private int yearPublishing;

    public Book(int id) {
        this.id = id;
    }

    public Book(int id, String authorName, String authorSurname, String authorPatronymic, String name, int yearPublishing) {
        this.id = id;
        this.authorName = authorName;
        this.authorSurname = authorSurname;
        this.authorPatronymic = authorPatronymic;
        this.name = name;
        this.yearPublishing = yearPublishing;
        this.owner = null;
    }
}
