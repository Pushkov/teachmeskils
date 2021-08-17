package com.home.library.service;

import com.home.library.model.Book;
import com.home.library.model.Reader;

import java.util.List;

public interface ILibraryBookService {
    Book findById(int id);

    List<Book> findAllBooks();

    List<Book> findAllBooksOrderByYear();

    List<Book> findAllBooksByReader(Reader reader);

    void addBookToLibrary(Book book);

    void removeBookFromLibrary(Book book);
}
