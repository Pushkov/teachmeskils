package com.home.library.service;

import com.home.library.model.Book;
import com.home.library.model.Reader;

public interface ILibraryService {
    void getBookToReader(Book book, Reader reader);
    void receiveBookToLibrary(Book book, Reader reader);
}
