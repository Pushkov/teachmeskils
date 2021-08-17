package com.home.library.model;

import java.util.ArrayList;
import java.util.List;

public class Library {
    List<Book> booksList;
    List<Reader> readersList;

    public List<Book> getBooksList() {
        if (booksList == null) {
            booksList = new ArrayList<>();
        }
        return booksList;
    }

    public List<Reader> getReadersList() {
        if (readersList == null) {
            readersList = new ArrayList<>();
        }
        return readersList;
    }
}
