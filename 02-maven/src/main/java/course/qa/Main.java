package course.qa;

import course.qa.dao.IdGenerator;
import course.qa.dao.UserRepository;
import course.qa.dao.impl.LongIdGenerator;
import course.qa.dao.impl.UserRepositoryMemoryImpl;
import course.qa.exception.InvalidEntityDataException;
import course.qa.exception.NonexistingEntityException;
import course.qa.model.Role;
import course.qa.model.User;
import course.qa.service.UserService;
import course.qa.service.impl.UserServiceImpl;
import course.qa.util.UserValidator;

import java.util.List;

import static course.qa.model.Role.AUTHOR;

public class Main {
    public static void main(String[] args) {
        // Users demo
        List<User> users = List.of(
                new User("Ivan", "Petrov", 28, "ivan", "Ivan123#"),
                new User("John", "Doe", 42, "john", "John123#", Role.ADMIN,
                        "+(1) 23424242323", true),
                new User("Jane", "Doe", 34, "jane", "Jane123#", AUTHOR,
                        "+(359) 889654532", true)
        );

        // Create UserRepository
        IdGenerator<Long> longIdGenerator = new LongIdGenerator();
        UserRepository userRepo = new UserRepositoryMemoryImpl(longIdGenerator);

        // Create UserService
        UserService userService = new UserServiceImpl(userRepo, new UserValidator());
        try {
            userService.addUsersBatch(users);
        } catch (InvalidEntityDataException e) {
            e.printStackTrace();
        }

//        for(User user: userRepo.findAll()){
//            System.out.println(user);
//        }
//        userRepo.findAll().forEach(user -> System.out.println(user));
        userService.getAllUsers().forEach(System.out::println);
        var john = userRepo.findByUsername("john").get();
        System.out.println("\nBefore update: " + john);

        //update user data
        john.setRole(AUTHOR);
        john.setPhone("+359 8888888888");
        john.setPassword("aaaaaaaA123#");
        john.setAge(45);
        try {
            userService.updateUser(john);
            var johnAfterUpdate = userService.getUserById(john.getId());
            System.out.println("After update: " + johnAfterUpdate);
        } catch (NonexistingEntityException | InvalidEntityDataException e) {
            e.printStackTrace();
        }

        // delete user
        try {
            userService.deleteUserById(john.getId());
            System.out.println("\nAfter delete:");
            userService.getAllUsers().forEach(System.out::println);
        } catch (NonexistingEntityException e) {
            e.printStackTrace();
        }
    }
}
