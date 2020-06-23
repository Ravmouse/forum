package ru.vitaly.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vitaly.entity.User;
import ru.vitaly.repository.UserRepository;

/**
 * @author Vitaly Vasilyev, date: 02.06.2020, e-mail: rav.energ@rambler.ru
 * @version 1.0
 */
@Service
public class UserService {

    private UserRepository users;

    @Autowired
    public UserService(UserRepository users) {
        this.users = users;
    }

    public User findById(int id) {
        return users.findById(id).get();
    }
}