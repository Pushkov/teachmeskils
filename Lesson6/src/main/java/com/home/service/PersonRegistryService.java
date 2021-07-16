package com.home.service;

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
