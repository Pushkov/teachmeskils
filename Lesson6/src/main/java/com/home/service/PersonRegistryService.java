package com.home.service;

//        Военкомат должен уметь:
//        a) вывести имена всех людей годных к военной службе на текущий момент времени, которые есть в PersonRegistry
//        T.е нужно написать метод в классе MilitaryOffice, который будет отфильтровывать годных к службе призывников
//        (годными считать мущин от 18 до 27 лет, проверяем пол и возраст)
//        б) вывести количество годных призывников в городе Минске.
//        в) вывести количество призывников от 25 до 27 лет
//        г) вывести количество призывников у которых имя Александр.
//
//        5) Создать класс Main, наполнить PersonRegistry людьми, по желанию можно создавать людей через консоль


import com.home.constant.Sex;
import com.home.model.Person;

import java.util.List;

public interface PersonRegistryService {

    void addPerson(Person person);

    void addPersons(List<Person> persons);

    List<Person> getAllPersons();

    List<Person> getAllSuitablePersons();

    List<Person> getAllSuitablePersonsBySex(Sex sex);

    List<Person> getAllSuitablePersonsByBetweenAge(Integer lowBound, Integer hiBound);

    List<Person> getAllSuitablePersonsByBetweenAgeAndSex(Integer lowBound, Integer hiBound, Sex sex);

    Long getCountSuitablePersons();

    Long getCountSuitablePersonsBySex(Sex sex);

    Long getCountSuitablePersonsByBetweenAge(Integer lowBound, Integer hiBound);

    Long getCountSuitablePersonsByBetweenAgeAndSex(Integer lowBound, Integer hiBound, Sex sex);

    Long getCountSuitablePersonsInCity(String city);

    Long getCountSuitablePersonsByName(String name);
}
