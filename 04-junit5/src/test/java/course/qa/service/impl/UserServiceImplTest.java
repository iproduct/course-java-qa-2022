package course.qa.service.impl;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import course.qa.dao.impl.LongIdGenerator;
import course.qa.dao.impl.UserRepositoryMemoryImpl;
import course.qa.model.User;
import course.qa.util.UserValidator;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

@Slf4j
class UserServiceImplTest {
    private static List<User> SAMPLE_USERS;

    @BeforeAll
    public static void setup() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        URL usersJsonFileUrl = UserServiceImplTest.class.getClassLoader().getResource("users.json");
        try {
            TypeReference<List<User>> userList = new TypeReference<List<User>>() { };
            SAMPLE_USERS = mapper.readValue(usersJsonFileUrl, userList);
            log.info("User loaded from JSON file: {}",
                    SAMPLE_USERS.stream().map(User::toString).collect(Collectors.joining("\n")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    @Test
//    void getAllUsers() {
//    }
//
//    @Test
//    void getUserById() {
//    }

    @TestFactory
    Stream<DynamicTest> addUser() {
        return SAMPLE_USERS.stream().map(user ->
                dynamicTest("Create user with JSON file data '" + user.getUsername() + "'", () -> {
                    var userService = new UserServiceImpl(
                            new UserRepositoryMemoryImpl(new LongIdGenerator()), new UserValidator());
                    User actual = userService.addUser(user);
                    assertNotNull(actual);
                    assertNotNull(actual.getId());
                    assertEquals(Long.valueOf(1L), actual.getId());
                })
        );
    }

//    @Test
//    void addUsersBatch() {
//    }
//
//    @Test
//    void updateUser() {
//    }
//
//    @Test
//    void deleteUserById() {
//    }
//
//    @Test
//    void count() {
//    }
}
