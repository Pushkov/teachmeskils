package com.home.library.service;

import com.home.library.model.Library;
import com.home.library.model.Reader;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@AllArgsConstructor
public class ReaderServiceImpl implements IReaderService {
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

    @Override
    public List<Reader> findAllOwnersByAuthor(String authorName, String authorSurname, String authorPatronymic) {
        return findAllReaders().stream()
                .filter(reader -> isOwner(authorName, authorSurname, authorPatronymic, reader))
                .collect(Collectors.toList());
    }

    private boolean isOwner(String authorName, String authorSurname, String authorPatronymic, Reader reader) {
        return reader.getBookList().stream()
                .anyMatch(book -> book.getAuthorName().equals(authorName) &&
                        book.getAuthorSurname().equals(authorSurname) &&
                        book.getAuthorPatronymic().equals(authorPatronymic));
    }
}
