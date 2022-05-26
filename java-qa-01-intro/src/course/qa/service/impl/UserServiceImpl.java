package course.qa.service.impl;

import course.qa.dao.UserRepository;
import course.qa.exception.NonexistingEntityException;
import course.qa.model.User;
import course.qa.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

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
    public User getUserById(Long id) throws NonexistingEntityException {
        return userRepo.findById(id).orElseThrow(
                () -> new NonexistingEntityException("User with ID='" + id + "' does not exist"));
    }

    @Override
    public User addUser(User user) {
        return userRepo.create(user);
    }

    @Override
    public List<User> addUsersBatch(List<User> users) {
        return users.stream().map(userRepo::create).collect(Collectors.toList());
    }

    @Override
    public User updateUser(User user) throws NonexistingEntityException {
        return userRepo.update(user)
                .orElseThrow(() -> new NonexistingEntityException("User does not exist: " + user));
    }

    @Override
    public User deleteUserById(Long id) throws NonexistingEntityException {
        return userRepo.deleteById(id)
                .orElseThrow(() -> new NonexistingEntityException("User with ID='" + id + "' does not exist"));
    }

    @Override
    public long count() {
        return userRepo.count();
    }
}
