package com.home.library;

import com.home.library.model.Book;
import com.home.library.model.EmailAddress;
import com.home.library.model.Library;
import com.home.library.model.Reader;
import com.home.library.service.ILibraryBookService;
import com.home.library.service.ILibraryReaderService;
import com.home.library.service.IMessagingService;
import com.home.library.service.LibraryManager;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static com.home.library.util.Constants.*;
import static com.home.util.MyUtil.printCollection;
import static com.home.util.MyUtil.printWord;
import static java.lang.String.join;
import static java.util.stream.Collectors.*;

public class LibraryMain {
    LibraryManager libraryManager = new LibraryManager(new Library());
    ILibraryBookService bookService = libraryManager.getBookService();
    ILibraryReaderService readerService = libraryManager.getReaderService();
    IMessagingService messagingService = libraryManager.getMessagingService();

    public void startLibrary() {
        initBookList().forEach(bookService::addBookToLibrary);
        initReadersList().forEach(readerService::addReaderToLibrary);
        Map<Integer, List<Integer>> initBooksMap = initReadersBookLists();
        var keys = initBooksMap.keySet();
        keys.forEach(k -> initBooksMap.get(k).forEach(value -> libraryManager.getBookToReader(k, value)));

        point_1();
        point_2();
        point_3();
        point_4();
        point_5();
        point_1_adv();
        point_2_adv();
        point_3_adv();
        point_4_adv();
    }

    private void point_1() {
        System.out.println("\n - Find all books from library ordered by year of production");
        List<Book> allBooks = bookService.findAllBooksOrderByYear();
        printCollection(allBooks, false);
    }

    private void point_2() {
        System.out.println("\n - Create a mailing list for all readers");
        List<EmailAddress> mailingListForAll = messagingService.createMailingList("message for all", readerService.findAllReaders());
        printCollection(mailingListForAll, false);
    }

    private void point_3() {
        System.out.println("\n - Create a mailing list for readers who given consent and reader has more that one book");
        List<Reader> readersWithManyBooks = readerService.findAllAgreeReaders().stream()
                .filter(reader -> reader.getBookList().size() > 1)
                .collect(Collectors.toList());
        List<EmailAddress> mailingListForAgree = messagingService.createMailingList("for agree", readersWithManyBooks);
        printCollection(mailingListForAgree, false);
    }

    private void point_4() {
        System.out.println("\n - Create a list of books that readers have");
        List<Book> booksFromReaders = readerService.findAllReaders().stream()
                .flatMap(reader -> bookService.findAllBooksByReader(reader).stream())
                .distinct()
                .sorted(Comparator.comparing(Book::getId))
                .collect(Collectors.toList());
        printCollection(booksFromReaders, false);
    }

    private void point_5() {
        System.out.println("\n - Check which of the readers has the author's book");
        Map<Boolean, List<Reader>> booksFromReader = readerService.findAllReaders().stream()
                .collect(partitioningBy(
                        reader -> bookService.findAllBooksByReader(reader).stream()
                                .anyMatch(book -> {
                                    return book.getAuthorName().equals(AUTHOR_NAME) &&
                                            book.getAuthorSurname().equals(AUTHOR_SURNAME) &&
                                            book.getAuthorPatronymic().equals(AUTHOR_PATRONYMIC);
                                }),
                        toList()
                        )
                );
        printCollection(booksFromReader.get(true), false);
    }

    private void point_1_adv() {
        System.out.println("\n - Find maximum number of books readers have");
        Reader maxBookCount = readerService.findAllReaders().stream()
                .max(Comparator.comparing(reader -> reader.getBookList().size()))
                .orElseThrow(() -> new NoSuchElementException(""));
        System.out.println("Reader id who has the maximum number of books: " + maxBookCount.getId());
    }

    private void point_2_adv() {
        System.out.println("\n - Create a mailing list for two groups of readers");
        Map<Boolean, List<Reader>> readersListsForMailing = getReadersListsForMailing();
        List<EmailAddress> mailingNews = messagingService.createMailingList("OK", readersListsForMailing.get(false));
        System.out.println("Mailing list with news");
        printCollection(mailingNews, false);
        List<EmailAddress> mailingRemember = messagingService.createMailingList("TOO_MUCH", readersListsForMailing.get(true));
        System.out.println("Return reminder mailing list");
        printCollection(mailingRemember, false);
    }

    private void point_3_adv() {
        System.out.println("\n - Print two readers lists");
        Map<Boolean, List<Reader>> readersLists = getReadersListsForMailing();
        System.out.println("Readers list TOO_MUCH");
        printCollection(readersLists.get(true), false);
        System.out.println("Readers list OK");
        printCollection(readersLists.get(false), false);
    }

    private void point_4_adv() {
        System.out.println("\n - Print two STRING for any readers list");
        Map<Boolean, List<Reader>> mailingLists = getReadersListsForMailing();
        List<Reader> listTooMuch = mailingLists.get(true);
        String stringTooMuch = listTooMuch.stream()
                .map(reader -> join(" ", List.of(reader.getFirstName(), reader.getLastName())))
                .collect(joining(",", "{", "}"));
        printWord("TOO_MUCH " + stringTooMuch, false);
        List<Reader> listOk = mailingLists.get(false);
        String stringOk = listOk.stream()
                .map(reader -> join(" ", List.of(reader.getFirstName(), reader.getLastName())))
                .collect(joining(",", "{", "}"));
        printWord("OK " + stringOk, false);
    }

    private Map<Boolean, List<Reader>> getReadersListsForMailing() {
        return readerService.findAllReaders().stream()
                .collect(partitioningBy(
                        reader -> bookService.findAllBooksByReader(reader).size() >= 2,
                        toList()
                ));
    }

    private List<Book> initBookList() {
        return List.of(
                new Book(1, "Александр", "Пушкин", "Сергеевич", "Сказки", 1998),
                new Book(3, "Александр", "Пушкин", "Сергеевич", "Евгений Онегин", 2005),
                new Book(4, "Михаил", "Лермонтов", "Юрьевич", "Бородино", 2010),
                new Book(5, "Михаил", "Лермонтов", "Юрьевич", "Кавказский пленник", 2003),
                new Book(7, "Лев", "Толстой", "Николаевич", "Война и мир", 2015),
                new Book(8, "Федор", "Достоевский", "Михайлович", "Идиот", 2017),
                new Book(9, "Федор", "Достоевский", "Михайлович", "Братья Карамазовы", 2001),
                new Book(11, "Эрнест", "Хемингуэй", "", "Старик и море", 1998),
                new Book(12, "Алексей", "Толстой", "Николаевич", "Петр 1", 1969),
                new Book(20, "Михаил", "Булгаков", "Афанасьевич", "Мастер и Маргарита", 1987)
        );
    }

    private List<Reader> initReadersList() {
        return List.of(
                new Reader(1, "Алекс", "Александров", "alex@mail.ru", true),
                new Reader(2, "Иван", "Иванов", "ivan@rambler.ru", false),
                new Reader(3, "Петр", "Петров", "pp@mail.ru", true),
                new Reader(6, "Денис", "Денисов", "den@gmail.com", false),
                new Reader(7, "Виктор", "Викторов", "vvv@tut.by", false),
                new Reader(8, "Сергей", "Сергеев", "serg@yahoo.com", true)
        );
    }

    private Map<Integer, List<Integer>> initReadersBookLists() {
        return Map.of(
                1, List.of(1, 4, 5, 7),
                2, List.of(1, 5, 7),
                3, List.of(20),
                6, List.of(3, 8, 9, 11),
                7, List.of(11, 12, 20),
                8, List.of(1));
    }
}
