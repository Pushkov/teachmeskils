package com.home.library.service;

import com.home.library.model.Book;
import com.home.library.model.Library;
import com.home.library.model.Reader;
import lombok.Getter;

import java.util.List;
import java.util.NoSuchElementException;

@Getter
public class LibraryManager implements ILibraryService {
    private final Library library;
    private final ILibraryBookService bookService;
    private final ILibraryReaderService readerService;
    private final IMessagingService messagingService;

    public LibraryManager(Library library) {
        this.library = library;
        this.bookService = new LibraryBookServiceImpl(library);
        this.readerService = new LibraryReaderServiceImpl(library);
        this.messagingService = new MessagingServiceImpl();
    }

    @Override
    public void getBookToReader(int readerId, int bookId) {
        try {
            Book book = bookService.findById(bookId);
            List<Book> readersBooks = getBooksFromReader(readerId);
            readersBooks.add(book);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void receiveBookToLibrary(int bookId, int readerId) {
        try {
            Book book = bookService.findById(bookId);
            List<Book> readerBooks = getBooksFromReader(readerId);
            readerBooks.remove(book);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }

    private List<Book> getBooksFromReader(int readerId) {
        List<Book> readerBooks = null;
        try {
            Reader reader = readerService.findById(readerId);
            readerBooks = bookService.findAllBooksByReader(reader);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        return readerBooks;
    }
}
