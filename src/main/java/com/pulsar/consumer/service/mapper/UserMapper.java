package com.pulsar.consumer.service.mapper;

import com.pulsar.consumer.dto.User;
import com.pulsar.consumer.model.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper USER_MAPPER= Mappers.getMapper(UserMapper.class);

    User mapToUserDto(UserEntity user);
    List<User> mapToListUserDto(List<UserEntity> user);
    UserEntity mapToUserEntity(User user);
}
