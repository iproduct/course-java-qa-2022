package course.qa.service;

import course.qa.exception.EntityNotFoundException;
import course.qa.exception.NonexistingEntityException;
import course.qa.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id) throws NonexistingEntityException;
    User addUser(User user);
    List<User> addUsersBatch(List<User> users);
    User updateUser(User user) throws NonexistingEntityException;
    User deleteUserById(Long id);
    long count();
}
