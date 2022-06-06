package course.qa.service.impl;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import course.qa.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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
//        SAMPLE_USERS
    }

    @Test
    void getAllUsers() {
    }

    @Test
    void getUserById() {
    }

    @TestFactory
    Collection<DynamicNode> addUser() {
        return List.of(
                dynamicTest("Create user with default data", () -> {
//                    var created =
                })
        );
    }

    @Test
    void addUsersBatch() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteUserById() {
    }

    @Test
    void count() {
    }
}
