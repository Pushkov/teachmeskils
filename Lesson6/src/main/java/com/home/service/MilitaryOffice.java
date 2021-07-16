package com.home.service;

import com.home.constant.Sex;
import com.home.model.Person;

import java.util.List;

public class MilitaryOffice {

    private final PersonRegistryService registryService;

    public MilitaryOffice(PersonRegistryService registryService) {
        this.registryService = registryService;
    }

    public void addPersonToRegisrtyOffice(Person person) {
        registryService.addPerson(person);
    }

    public void addPersonsToRegisrtyOffice(List<Person> persons) {
        registryService.addPersons(persons);
    }

    public List<Person> getAllPersons() {
        return registryService.getAllPersons();
    }

    public List<Person> getAllSuitablePersons() {
        return registryService.getAllSuitablePersons();
    }

    public List<Person> getAllSuitablePersonsBySex(Sex sex) {
        return registryService.getAllSuitablePersonsBySex(sex);
    }

    public List<Person> getAllSuitablePersonsByBetweenAge(Integer lowBound, Integer hiBound) {
        return registryService.getAllSuitablePersonsByBetweenAge(lowBound, hiBound);
    }

    public List<Person> getAllSuitablePersonsByBetweenAgeAndSex(Integer lowBound, Integer hiBound, Sex sex) {
        return registryService.getAllSuitablePersonsByBetweenAgeAndSex(lowBound, hiBound, sex);
    }

    public Long getCountSuitablePersons() {
        return registryService.getCountSuitablePersons();
    }

    public Long getCountSuitablePersonsBySex(Sex sex) {
        return registryService.getCountSuitablePersonsBySex(sex);
    }

    public Long getCountSuitablePersonsByBetweenAge(Integer lowBound, Integer hiBound) {
        return registryService.getCountSuitablePersonsByBetweenAge(lowBound, hiBound);
    }

    public Long getCountSuitablePersonsByBetweenAgeAndSex(Integer lowBound, Integer hiBound, Sex sex) {
        return registryService.getCountSuitablePersonsByBetweenAgeAndSex(lowBound, hiBound, sex);
    }

    public Long getCountSuitablePersonsInCity(String city) {
        return registryService.getCountSuitablePersonsInCity(city);
    }

    public Long getCountSuitablePersonsByName(String name) {
        return registryService.getCountSuitablePersonsByName(name);
    }
}
