package com.home.library.service;

import com.home.library.model.Book;
import com.home.library.model.Library;
import com.home.library.model.Reader;
import lombok.AllArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@AllArgsConstructor
public class LibraryBookServiceImpl implements ILibraryBookService {
    private final Library library;

    @Override
    public Book findById(int id) {
        return findAllBooks().stream()
                .filter(book -> book.getId() == id)
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("Book with id:" + id + " not found."));
    }

    @Override
    public List<Book> findAllBooks() {
        return library.getBooksList();
    }

    @Override
    public List<Book> findAllBooksOrderByYear() {
        return findAllBooks().stream()
                .sorted(Comparator.comparing(Book::getYearPublishing))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> findAllBooksByReader(Reader reader) {
        return reader.getBookList();
    }

    @Override
    public void addBookToLibrary(Book book) {
        findAllBooks().add(book);
    }

    @Override
    public void removeBookFromLibrary(Book book) {
        findAllBooks().remove(book);
    }
}
