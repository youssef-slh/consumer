package com.pulsar.consumer.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public enum UserType {

    STUDENT(1,"Student"),
    EMPLOYEE(2,"Employee");

    private int code;
    private String name;
}
