package com.zufar.service;

import com.zufar.domain.User;
import com.zufar.repository.CountryRepository;
import com.zufar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final CountryRepository countryRepository;

    @Autowired
    public UserService(UserRepository userRepository, CountryRepository countryRepository) {
        this.userRepository = userRepository;
        this.countryRepository = countryRepository;
    }

    public void save(User user) {
        userRepository.persist(user);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public void update(User user) {
        userRepository.update(user);
    }

    public User get(String login, String password) {
        return userRepository.get(login, password);
    }

    public User get(Long id) {
        return userRepository.get(id);
    }

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public boolean isLoginUnique(String loging) {
        return userRepository.isLoginUnique(loging);
    }
}