package course.qa;

import course.qa.model.Person;
import course.qa.model.Role;
import course.qa.model.User;

import java.util.List;

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

        // Users demo
        List<User> users = List.of(
                new User("Ivan", "Petrov", 28, "ivan", "ivan123"),
                new User("John", "Doe", 42, "john", "john123", Role.ADMIN,
                        "+(1) 23424242323", true),
                new User("Jane", "Doe", 34, "jane", "jane123", Role.AUTHOR,
                        "+(359) 889654532", true)
        );
        for(User user: users){
            System.out.println(user.toString());
        }
    }
}
