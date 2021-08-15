package com.home.library.service;

import com.home.library.model.Book;

import java.util.List;

public interface IBookService {
    Book findById(int id);

    Book findByBookName(String name);

    Book findByAuthorName(String authorName);

    Book findByAuthorSurname(String authorSurname);

    List<Book> findAllBooks();

    List<Book> findAllBooksOrderByYear();

    void addBookToLibrary(Book book);

    void removeBookFromLibrary(Book book);
}
