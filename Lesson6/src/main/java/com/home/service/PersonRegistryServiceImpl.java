package com.home.service;

import com.home.constant.Sex;
import com.home.model.Person;
import com.home.model.PersonRegistry;

import java.util.List;
import java.util.stream.Collectors;

public class PersonRegistryServiceImpl implements PersonRegistryService {

    private final PersonRegistry personRegistry;

    public PersonRegistryServiceImpl(PersonRegistry personRegistry) {
        this.personRegistry = personRegistry;
    }

    @Override
    public void addPerson(Person person) {
        personRegistry.getPersonList().add(person);
    }

    @Override
    public void addPersons(List<Person> persons) {
        personRegistry.getPersonList().addAll(persons);
    }

    @Override
    public List<Person> getAllPersons() {
        return personRegistry.getPersonList();
    }

    @Override
    public List<Person> getAllSuitablePersons() {
        Integer lowBound = 18;
        Integer hiBound = 27;
        return getAllSuitablePersonsByBetweenAge(lowBound, hiBound);
    }

    @Override
    public List<Person> getAllSuitablePersonsBySex(Sex sex) {
        Integer lowBound = 18;
        Integer hiBound = 27;
        return getAllSuitablePersonsByBetweenAgeAndSex(lowBound, hiBound, sex);
    }

    @Override
    public List<Person> getAllSuitablePersonsByBetweenAge(Integer lowBound, Integer hiBound) {
        return personRegistry.getPersonList()
                .stream()
                .filter(p -> p.getAge() >= lowBound && p.getAge() < hiBound)
                .collect(Collectors.toList());
    }

    @Override
    public List<Person> getAllSuitablePersonsByBetweenAgeAndSex(Integer lowBound, Integer hiBound, Sex sex) {
        return personRegistry.getPersonList()
                .stream()
                .filter(p -> p.getAge() >= lowBound && p.getAge() < hiBound && p.getSex() == sex)
                .collect(Collectors.toList());
    }

    @Override
    public Long getCountSuitablePersons() {
        return (long) personRegistry.getPersonList().size();
    }

    @Override
    public Long getCountSuitablePersonsBySex(Sex sex) {
        return personRegistry.getPersonList()
                .stream()
                .filter(p -> p.getSex() == sex)
                .count();
    }

    @Override
    public Long getCountSuitablePersonsByBetweenAge(Integer lowBound, Integer hiBound) {
        return personRegistry.getPersonList()
                .stream()
                .filter(p -> p.getAge() >= lowBound && p.getAge() < hiBound)
                .count();
    }

    @Override
    public Long getCountSuitablePersonsByBetweenAgeAndSex(Integer lowBound, Integer hiBound, Sex sex) {
        return personRegistry.getPersonList()
                .stream()
                .filter(p -> p.getAge() >= lowBound && p.getAge() < hiBound && p.getSex() == sex)
                .count();
    }

    @Override
    public Long getCountSuitablePersonsInCity(String city) {
        return personRegistry.getPersonList()
                .stream()
                .filter(p -> p.getCity().equals(city))
                .count();
    }

    @Override
    public Long getCountSuitablePersonsByName(String name) {
        return personRegistry.getPersonList()
                .stream()
                .filter(p -> p.getName().equals(name))
                .count();
    }
}
