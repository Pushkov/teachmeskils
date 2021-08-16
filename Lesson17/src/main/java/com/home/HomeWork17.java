package com.home;

import com.home.library.model.Book;
import com.home.library.model.EmailAddress;
import com.home.library.model.Library;
import com.home.library.model.Reader;
import com.home.library.service.ILibraryBookService;
import com.home.library.service.ILibraryReaderService;
import com.home.library.service.IMessagingService;
import com.home.library.service.LibraryManager;
import com.home.model.Car;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

import static com.home.library.util.LibraryUtils.printMap;
import static com.home.util.MyUtil.*;
import static java.util.stream.Collectors.*;

public class HomeWork17 {
    public static void main(String[] args) {
        point1();
        point2();
        point3();
        point4();
        point5_1();
        point5_2();
        point6();
    }

    private static void point1() {
        System.out.println(" 1)");
        ArrayList<Integer> list = getIntegerList(10, 30);
        printCollection(list, true);
        System.out.println();
        list.stream()
                .map(number -> number * 2)
                .forEach(number -> printWord(number, true));
        System.out.println();
    }

    private static void point2() {
        System.out.println(" 2)");
        Set<Integer> set = getSet();
        printCollection(set, true);
        System.out.println("\n" + set.size());
        int count = (int) set.stream()
                .filter(integer -> integer % 2 == 0)
                .count();
        System.out.println(count);
    }

    private static void point3() {
        System.out.println(" 3)");
        List<String> listNames = List.of("john", "arya", "sansa");
        listNames.stream()
                .map(StringUtils::capitalize)
                .forEach(x -> printWord(x, true));
        System.out.println();
    }

    private static void point4() {
        System.out.println(" 4)");
        List<Car> cars = List.of(
                new Car("AA1111BX", 2007),
                new Car("AK5555IT", 2010),
                new Car(null, 2012),
                new Car("", 2015),
                new Car("AI3838PP", 2017));
        cars.stream()
                .filter(car -> car.getYear() >= 2010)
                .map(Car::getNumber)
                .filter(Objects::nonNull)
                .filter(x -> !x.equals(""))
                .forEach(System.out::println);
    }


    private static void point5_1() {
        System.out.println(" 5.1)");
        var list = getPersonsList();
        list.stream()
                .filter(person -> person.getLastName().startsWith("Д"))
                .forEach(System.out::println);
    }

    private static void point5_2() {
        System.out.println(" 5.2)");
        var list = getPersonsList();
        Map<String, Long> personsByFirstLetterInLastName = list.stream()
                .collect(groupingBy(person -> person.getLastName().substring(0, 1), counting()));
        printMap(personsByFirstLetterInLastName);
    }

    private static void point6() {
        System.out.println(" 6)");
        LibraryManager libraryManager = new LibraryManager(new Library());
        ILibraryBookService bookService = libraryManager.getBookService();
        ILibraryReaderService readerService = libraryManager.getReaderService();
        IMessagingService messagingService = libraryManager.getMessagingService();
        init:
        {
            initBookList().forEach(bookService::addBookToLibrary);
            initReadersList().forEach(readerService::addReaderToLibrary);

            libraryManager.getBookToReader(1, 1);
            libraryManager.getBookToReader(4, 1);
            libraryManager.getBookToReader(5, 1);
            libraryManager.getBookToReader(7, 1);
            libraryManager.getBookToReader(1, 2);
            libraryManager.getBookToReader(5, 2);
            libraryManager.getBookToReader(7, 2);
            libraryManager.getBookToReader(8, 2);
            libraryManager.getBookToReader(20, 3);
            libraryManager.getBookToReader(8, 6);
            libraryManager.getBookToReader(9, 6);
            libraryManager.getBookToReader(11, 6);
            libraryManager.getBookToReader(11, 7);
            libraryManager.getBookToReader(12, 7);
            libraryManager.getBookToReader(20, 7);
            libraryManager.getBookToReader(1, 8);
        }
        point6_1:
        {
            System.out.println("point a -");
            List<Book> allBooks = bookService.findAllBooksOrderByYear();
            printCollection(allBooks, false);
        }
        point6_2:
        {
            System.out.println("\npoint b -");
            List<EmailAddress> mailingListForAll = messagingService.createMailingList("message for all", readerService.findAllReaders());
            printCollection(mailingListForAll, false);
        }
        point6_3:
        {
            System.out.println("\npoint c -");
            List<Reader> readersWithManyBooks = readerService.findAllAgreeReaders().stream()
                    .filter(reader -> reader.getBookList().size() > 1)
                    .collect(Collectors.toList());
            List<EmailAddress> mailingListForAgree = messagingService.createMailingList("for agree", readersWithManyBooks);
            printCollection(mailingListForAgree, false);
        }
        point6_4:
        {
            System.out.println("\npoint d -");
            List<Book> booksFromReaders = readerService.findAllReaders().stream()
                    .flatMap(reader -> bookService.findAllBooksByReader(reader).stream())
                    .distinct()
                    .sorted(Comparator.comparing(Book::getId))
                    .collect(Collectors.toList());
            printCollection(booksFromReaders, false);
        }
        point6_5:
        {
            System.out.println("\npoint e -");
            Map<Boolean, List<Reader>> booksFromReader = readerService.findAllReaders().stream()
                    .collect(partitioningBy(
                            reader -> bookService.findAllBooksByReader(reader).stream()
                                    .anyMatch(book -> {
                                        return book.getAuthorName().equals("Александр") &&
                                                book.getAuthorSurname().equals("Пушкин") &&
                                                book.getAuthorPatronymic().equals("Сергеевич");
                                    }),
                            toList()
                            )
                    );
            printCollection(booksFromReader.get(true), false);
        }
        System.out.println();
        {
            System.out.println("\npoint a* -");
            Reader maxBookCount = readerService.findAllReaders().stream()
                    .max(Comparator.comparing(reader -> reader.getBookList().size()))
                    .orElseThrow(() -> new NoSuchElementException("12"));
            System.out.println("Reader id - " + maxBookCount.getId());
        }
        {
            System.out.println("\npoint b* -");
            Map<Boolean, List<Reader>> mailingLists = readerService.findAllReaders().stream()
                    .collect(partitioningBy(
                            reader -> bookService.findAllBooksByReader(reader).size() >= 2,
                            toList()
                    ));
            System.out.println("mailing for new books");
            List<EmailAddress> mailingNews = messagingService.createMailingList("OK", mailingLists.get(false));
            printCollection(mailingNews, false);
            System.out.println("mailing for remind");
            List<EmailAddress> mailingRemember = messagingService.createMailingList("TOO_MUCH", mailingLists.get(true));
            printCollection(mailingRemember, false);
        }
        {
            System.out.println("\npoint c* -");
            List<Reader> listForMailingC = readerService.findAllAgreeReaders().stream()
                    .filter(reader -> bookService.findAllBooksByReader(reader).size() > 1)
                    .collect(toList());
            printCollection(listForMailingC, false);
        }
        {
            System.out.println("\npoint d* -");
            Map<Boolean, List<Reader>> mailingLists = readerService.findAllReaders().stream()
                    .collect(partitioningBy(
                            reader -> bookService.findAllBooksByReader(reader).size() >= 2,
                            toList()
                    ));
            List<Reader> list1 = mailingLists.get(true);
            String sList1 = list1.stream()
                    .map(reader -> String.join(" ", List.of(reader.getFirstName(), reader.getLastName())))
                    .collect(joining(",", "{", "}"));
            printWord("TOO_MUCH " + sList1, false);
            List<Reader> list2 = mailingLists.get(false);
            String sList2 = list2.stream()
                    .map(reader -> String.join(" ", List.of(reader.getFirstName(), reader.getLastName())))
                    .collect(joining(",", "{", "}"));
            printWord("OK " + sList2, false);
        }

    }

    private static List<Book> initBookList() {
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

    private static List<Reader> initReadersList() {
        return List.of(
                new Reader(1, "Алекс", "Александров", "alex@mail.ru", true),
                new Reader(2, "Иван", "Иванов", "ivan@rambler.ru", false),
                new Reader(3, "Петр", "Петров", "pp@mail.ru", true),
                new Reader(6, "Денис", "Денисов", "den@gmail.com", false),
                new Reader(7, "Виктор", "Викторов", "vvv@tut.by", false),
                new Reader(8, "Сергей", "Сергеев", "serg@yahoo.com", true)
        );
    }

}
