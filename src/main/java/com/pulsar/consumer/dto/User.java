package com.pulsar.consumer.dto;

import com.pulsar.consumer.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String firstName;
    private String lastName;
    private UserType userType;
}
