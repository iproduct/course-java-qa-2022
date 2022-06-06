package course.qa.service.impl;

import course.qa.model.User;
import org.junit.jupiter.api.*;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

class UserServiceImplTest {
    private static List<User> SAMPLE_USERS;

    @BeforeAll
    public static void setup() {

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
