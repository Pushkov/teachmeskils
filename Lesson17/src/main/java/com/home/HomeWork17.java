package com.home;

import com.home.library.model.Book;
import com.home.library.model.EmailAddress;
import com.home.library.model.Library;
import com.home.library.model.Reader;
import com.home.library.service.IBookService;
import com.home.library.service.IMessagingService;
import com.home.library.service.IReaderService;
import com.home.library.service.LibraryManager;
import com.home.model.Car;
import com.home.util.MyUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

import static com.home.library.util.LibraryUtils.print;
import static com.home.util.MyUtil.*;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class HomeWork17 {
    public static void main(String[] args) {
//        point1();
//        point2();
//        point3();
//        point4();
//        point5_1();
//        point5_2();
        point6();
    }

    private static void point1() {
        ArrayList<Integer> list = getIntegerList(10, 30);
        printCollection(list);
        System.out.println();
        list.stream()
                .map(number -> number * 2)
                .forEach(MyUtil::printWord);
    }

    private static void point2() {
        Set<Integer> set = getSet();
        printCollection(set);
        System.out.println("\n" + set.size());
        int count = (int) set.stream()
                .filter(integer -> integer % 2 == 0)
                .count();
        System.out.println(count);
    }

    private static void point3() {
        List<String> listNames = List.of("john", "arya", "sansa");
        listNames.stream()
                .map(StringUtils::capitalize)
                .forEach(MyUtil::printWord);

    }

    private static void point4() {
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
        var list = getPersonsList();
        list.stream()
                .filter(person -> person.getLastName().startsWith("Д"))
                .forEach(System.out::println);
    }

    private static void point5_2() {
        var list = getPersonsList();
        Map<String, Long> personsByFirstLetterInLastName = list.stream()
                .collect(groupingBy(person -> person.getLastName().substring(0, 1), counting()));
        print(personsByFirstLetterInLastName);
    }

    private static void point6() {
        LibraryManager libraryManager = new LibraryManager(new Library());
        IBookService bookService = libraryManager.getBookService();
        IReaderService readerService = libraryManager.getReaderService();
        IMessagingService messagingService = libraryManager.getMessagingService();
        initBookList().forEach(bookService::addBookToLibrary);
        initReadersList().forEach(readerService::addReaderToLibrary);


        System.out.println("point a");
        List<Book> allBooks = bookService.findAllBooks();
        printCollection(allBooks);
        System.out.println("\npoint b");
        List<EmailAddress> mailingListForAll = messagingService.createMailingList("message for all", readerService.findAllReaders());
        printCollection(mailingListForAll);
        System.out.println("\npoint c");
        List<Reader> readersWithManyBooks = readerService.findAllAgreeReaders().stream()
                .filter(reader -> reader.getBookList().size() > 1)
                .collect(Collectors.toList());
        List<EmailAddress> mailingListForAgree = messagingService.createMailingList("for agree", readersWithManyBooks);
        printCollection(mailingListForAgree);

        System.out.println("\n2 - ");
        printCollection(bookService.findAllBooksOrderByYear());
        System.out.println("\n3 - ");
        printCollection(readerService.findAllReaders());


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
