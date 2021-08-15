package com.home.library.service;

import com.home.library.model.Book;
import com.home.library.model.Library;
import com.home.library.model.Reader;
import lombok.Getter;

import java.util.List;

@Getter
public class LibraryServiceImpl implements ILibraryService, IBookService {
    private final Library library;

    public LibraryServiceImpl(Library library) {
        this.library = library;
    }

    @Override
    public void getBookToReader(Book book, Reader reader) {

    }

    @Override
    public void receiveBookToLibrary(Book book, Reader reader) {

    }

    @Override
    public Book findById(int id) {
        return null;
    }

    @Override
    public Book findByBookName(String name) {
        return null;
    }

    @Override
    public Book findByAuthorName(String authorName) {
        return null;
    }

    @Override
    public Book findByAuthorSurname(String authorSurname) {
        return null;
    }

    @Override
    public List<Book> findAllBooks() {
        return null;
    }

    @Override
    public List<Book> findAllBooksOrderByYear() {
        return null;
    }

    @Override
    public void addBookToLibrary(Book book) {

    }

    @Override
    public void removeBookFromLibrary(Book book) {

    }
}
