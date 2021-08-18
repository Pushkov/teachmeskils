package com.home.library.service;

import com.home.library.model.Reader;

import java.util.List;

public interface ILibraryReaderService {
    Reader findById(int id);

    List<Reader> findAllReaders();

    List<Reader> findAllAgreeReaders();

    void addReaderToLibrary(Reader reader);

    void removeReaderFromLibrary(Reader reader);
}
