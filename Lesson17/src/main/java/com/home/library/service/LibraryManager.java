package com.home.library.service;

import com.home.library.model.Library;
import lombok.Getter;

@Getter
public class LibraryManager {
    private final Library library;
    private ILibraryService libraryService;
    private final IBookService bookService;
    private final IReaderService readerService;
    private final IMessagingService messagingService;

    public LibraryManager(Library library) {
        this.library = library;
        this.libraryService = new LibraryServiceImpl(library);
        this.bookService = new BookServiceImpl(library);
        this.readerService = new ReaderServiceImpl(library);
        this.messagingService = new MessagingServiceImpl();
    }
}
