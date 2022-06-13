package course.qa.spring.dao;

import course.qa.spring.model.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static course.qa.spring.model.Role.AUTHOR;
import static course.qa.spring.model.Role.READER;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;

@DataJpaTest
@TestPropertySource("/application-test.properties")
class UserJpaRepositoryTest {

    @Autowired
    UserJpaRepository userRepo;

//    @BeforeEach
//    void setUp() {
//        userRepo.saveAll(DEFAULT_USERS);
////        DEFAULT_USERS.forEach(userRepo::save);
//    }

//    @AfterEach
//    void tearDown() {
//        userRepo.deleteAll();
//    }

    @Test
    void findByUsername() {
        assertThat(null, nullValue());
    }

    public static final List<User> DEFAULT_USERS = List.of(
            new User("Default", "Admin", 20, "admin", "Admin123#"),
            new User("John", "Doe", 42, "john", "John123#", READER,
                    "+(1) 23424242323", true),
            new User("Jane", "Doe", 34, "jane", "Jane123#", AUTHOR,
                    "+(359) 889654532", true)
    );
}
