package course.qa.spring.init;

import course.qa.spring.model.Role;
import course.qa.spring.model.User;
import org.springframework.boot.CommandLineRunner;

import java.util.List;

import static course.qa.spring.model.Role.AUTHOR;
import static course.qa.spring.model.Role.READER;

public class DataInitializer implements CommandLineRunner {
    public static final List<User> DEFAULT = List.of(
            new User("Default", "Admin", 20, "admin", "Admin123#"),
            new User("John", "Doe", 42, "john", "John123#", READER,
                    "+(1) 23424242323", true),
            new User("Jane", "Doe", 34, "jane", "Jane123#", AUTHOR,
                    "+(359) 889654532", true)
    );

    @Override
    public void run(String... args) throws Exception {

    }
}
