package com.pulsar.consumer.service;

import com.pulsar.consumer.dto.User;
import com.pulsar.consumer.model.UserEntity;
import com.pulsar.consumer.repository.UserRepository;
import com.pulsar.consumer.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public User saveNew(User user) {
        UserEntity userEntity = UserMapper.USER_MAPPER.mapToUserEntity(user);
        UserEntity savedUser = this.userRepository.save(userEntity);
        User savedUserDto = UserMapper.USER_MAPPER.mapToUserDto(savedUser);
        return savedUserDto;
    }

    @Override
    public List<User> getAllUsers() {
        List<UserEntity> all = this.userRepository.findAll();
        List<User> users = UserMapper.USER_MAPPER.mapToListUserDto(all);
        return users;
    }
}
