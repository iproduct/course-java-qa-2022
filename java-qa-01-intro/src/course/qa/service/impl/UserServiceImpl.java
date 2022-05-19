package course.qa.service.impl;

import course.qa.dao.UserRepository;
import course.qa.exception.EntityNotFoundException;
import course.qa.model.User;
import course.qa.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserRepository userRepo;

    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(Long id) throws EntityNotFoundException {
        return userRepo.findById(id).orElseThrow(
                () -> new EntityNotFoundException("User with ID='" + id + "' not found"));
    }

    @Override
    public User addUser(User user) {
        return null;
    }

    @Override
    public List<User> addUsersBatch(List<User> users) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public User deleteUserById(Long id) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }
}
