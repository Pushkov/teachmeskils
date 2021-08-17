package com.home.library.service;

import com.home.library.model.Library;
import com.home.library.model.Reader;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@AllArgsConstructor
public class LibraryReaderServiceImpl implements ILibraryReaderService {
    private final Library library;

    @Override
    public Reader findById(int id) {
        return findAllReaders().stream()
                .filter(reader -> reader.getId() == id)
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("Reader with id:" + id + " not found."));
    }

    @Override
    public List<Reader> findAllReaders() {
        return library.getReadersList();
    }

    @Override
    public List<Reader> findAllAgreeReaders() {
        return findAllReaders().stream()
                .filter(Reader::isAgreementMailing)
                .collect(Collectors.toList());
    }

    @Override
    public void addReaderToLibrary(Reader reader) {
        findAllReaders().add(reader);
    }

    @Override
    public void removeReaderFromLibrary(Reader reader) {
        findAllReaders().remove(reader);
    }
}
