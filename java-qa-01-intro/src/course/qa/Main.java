package course.qa;

import course.qa.model.Person;

public class Main {
    public static void main(String[] args) {
        Person[] persons = {
                new Person(1L, "John", "Doe", 29),
                new Person(2L, "Jane", "Doe", 25),
                new Person(3L, "Jim", "Doe", 36),
        };

//        for(Person p : persons) {
//            System.out.println(p);
//        }
//        for(int i = 0; i < persons.length; i++) {
//            System.out.println(persons[i]);
//        }
        int i = 0;
//        while(i < persons.length) {
//            System.out.println(persons[i]);
//            i++;
//        }
        do {
            System.out.println(persons[i]);
            i++;
        } while (i < persons.length);
    }
}
