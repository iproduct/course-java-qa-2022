package course.qa;

import course.qa.dao.IdGenerator;
import course.qa.dao.UserRepository;
import course.qa.dao.impl.LongIdGenerator;
import course.qa.dao.impl.UserRepositoryMemoryImpl;
import course.qa.model.Person;
import course.qa.model.Role;
import course.qa.model.User;

import java.util.List;

import static course.qa.model.Role.AUTHOR;

public class Main {
    public static void main(String[] args) {
        // Users demo
        List<User> users = List.of(
                new User("Ivan", "Petrov", 28, "ivan", "ivan123"),
                new User("John", "Doe", 42, "john", "john123", Role.ADMIN,
                        "+(1) 23424242323", true),
                new User("Jane", "Doe", 34, "jane", "jane123", AUTHOR,
                        "+(359) 889654532", true)
        );

        // Create UserRepository
        IdGenerator<Long> longIdGenerator = new LongIdGenerator();
        UserRepository userRepo = new UserRepositoryMemoryImpl(longIdGenerator);
//        users.forEach(user -> userRepo.create(user));
        users.forEach(userRepo::create);

//        for(User user: userRepo.findAll()){
//            System.out.println(user);
//        }
//        userRepo.findAll().forEach(user -> System.out.println(user));
        userRepo.findAll().forEach(System.out::println);
        var john = userRepo.findByUsername("john").get();
        System.out.println("Before update: " + john);

        //update user data
        john.setRole(AUTHOR);
        john.setPhone("+359 8888888888");
        john.setPassword("aaaaaaaa123#");
        john.setAge(45);
        userRepo.update(john);
        var johnAfterUpdate = userRepo.findById(john.getId());
        System.out.println("After update: " + johnAfterUpdate);

        // delete user
        userRepo.deleteById(john.getId());
        System.out.println("After delete:");
        userRepo.findAll().forEach(System.out::println);
    }
}
