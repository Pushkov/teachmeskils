package com.home.library.service;

public interface ILibraryService {
    void getBookToReader(int bookId, int readerId);

    void receiveBookToLibrary(int bookId, int readerIdr);
}
