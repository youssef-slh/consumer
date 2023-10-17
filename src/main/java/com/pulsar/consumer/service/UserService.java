package com.pulsar.consumer.service;

import com.pulsar.consumer.dto.User;

import java.util.List;

public interface UserService {
    User saveNew(User user);
    List<User> getAllUsers();
}
