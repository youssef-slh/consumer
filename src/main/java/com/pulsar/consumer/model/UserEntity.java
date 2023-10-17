package com.pulsar.consumer.model;

import com.pulsar.consumer.enums.UserType;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Table(name = "tbl_user")
@Entity
@Builder
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "type")
    @Enumerated(EnumType.ORDINAL)
    private UserType userType;
}
