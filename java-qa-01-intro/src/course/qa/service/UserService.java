package course.qa.service;

import course.qa.exception.EntityNotFoundException;
import course.qa.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id) throws EntityNotFoundException;
    User addUser(User user);
    List<User> addUsersBatch(List<User> users);
    User updateUser(User user);
    User deleteUserById(Long id);
    long count();
}
