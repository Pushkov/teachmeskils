package com.home;

import com.home.model.Address;
import com.home.model.Person;
import com.home.model.PersonRegistry;
import com.home.service.MilitaryOffice;
import com.home.service.PersonRegistryService;
import com.home.service.PersonRegistryServiceImpl;

import java.util.List;

import static com.home.constant.Sex.FEMALE;
import static com.home.constant.Sex.MALE;

public class HomeWork6 {
    public static void main(String[] args) {
        //        Домашка: 6 урок
//        Необходимо написать военкомат.
//        1) Создаем класс военкомат MilitaryOffice
//        2) Создать в классе MilitaryOffice конструктор, который принимает PersonRegistry
//        3) PersonRegistry содержит список людей (Person), которые могут быть призваны в армию
//        4) Создать класс Person, который будет содержать следующие поля имя, возраст, пол, адрес(страна, город)
//
//        Военкомат должен уметь:
//        a) вывести имена всех людей годных к военной службе на текущий момент времени, которые есть в PersonRegistry
//        T.е нужно написать метод в классе MilitaryOffice, который будет отфильтровывать годных к службе призывников
//        (годными считать мущин от 18 до 27 лет, проверяем пол и возраст)
//        б) вывести количество годных призывников в городе Минске.
//        в) вывести количество призывников от 25 до 27 лет
//        г) вывести количество призывников у которых имя Александр.
//
//        5) Создать класс Main, наполнить PersonRegistry людьми, по желанию можно создавать людей через консоль

        PersonRegistryService registryService = new PersonRegistryServiceImpl(new PersonRegistry());
        MilitaryOffice office = new MilitaryOffice(registryService);
        office.addPersonsToRegisrtyOffice(initialiseList());

        System.out.println("Список всех военнообязанных:");
        printList(registryService.getAllPersons());
        System.out.println();
        System.out.println("Список всех военнообязанных подлежащих призыву:");
        printList(registryService.getAllSuitablePersonsBySex(MALE));
        System.out.println();
        System.out.printf("%d - Количество призывников в городе %s \n", office.getCountSuitablePersonsInCity("Минск"), "Минск");
        System.out.println();
        Integer low = 25;
        Integer hi = 27;
        System.out.println(
                office.getCountSuitablePersonsByBetweenAgeAndSex(low, hi, MALE)
                        + " - Количество призывников от " + low + " до " + hi + "  лет");
    }

    private static List<Person> initialiseList() {
        return List.of(
                new Person("Василий", 15, MALE, new Address("РБ", "Минск")),
                new Person("Александр", 21, MALE, new Address("РБ", "Гомель")),
                new Person("Ирина", 15, FEMALE, new Address("РБ", "Минск")),
                new Person("Федор", 26, MALE, new Address("РБ", "Витебск")),
                new Person("Ольга", 19, FEMALE, new Address("РБ", "Брест")),
                new Person("Наталья", 25, FEMALE, new Address("РБ", "Гродно")),
                new Person("Илья", 27, MALE, new Address("РБ", "Могилев")),
                new Person("Матвей", 31, MALE, new Address("РБ", "Минск")),
                new Person("Николай", 42, MALE, new Address("РБ", "Минск")),
                new Person("Александр", 18, MALE, new Address("РБ", "Минск"))
        );
    }

    private static void printList(List<?> list) {
        for (Object p : list) {
            System.out.println(p);
        }
    }
}
