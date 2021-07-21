package com.tms;

import static com.tms.conts.Sex.MALE;

public class Main {
    public static void main(String[] args) {
//        Person person = new Person("Ddd", 33, MALE, new Address("Minsk", "па"));
//        System.out.println("city - " + person.getPersonCity());

        MilitaryOffice militaryOffice = new MilitaryOffice();
        Registry registry = new Registry();
        militaryOffice.setRegistry(registry);

        Person[] people = new Person[5];
//        Person person1 = new Person("Ddd", 33, MALE, new Address("Minsk", "па"));
//        Person person2 = new Person("Alex", 33, MALE, new Address("Minsk", "па"));
//        Person person3 = new Person("Victor", 33, MALE, new Address("Minsk", "па"));
//        Person person4 = new Person("Nick", 33, MALE, new Address("Minsk", "па"));
//        Person person5 = new Person("Maik", 33, MALE, new Address("Minsk", "па"));
//        people[0] = person1;
//        people[1] = person2;
//        people[2] = person3;
//        people[3] = person4;
//        people[4] = person5;
        people[0] = new Person("Ddd", 15, MALE, new Address("Minsk", "па"));
        people[1] = new Person("Alex", 33, MALE, new Address("Vitebsk", "па"));
        people[2] = new Person("Victor", 21, MALE, new Address("Mogilev", "па"));
        people[3] = new Person("Nick", 25, MALE, new Address("Minsk", "па"));
        people[4] = new Person("Maik", 27, MALE, new Address("Minsk", "па"));
        registry.setPersons(people);

//        militaryOffice.getRegistry().getAllSuitablePersons();
        militaryOffice.getSuitablePersons();
        System.out.println();
        militaryOffice.getRegistry().getPersonFromCity("Minsk");

    }
}
