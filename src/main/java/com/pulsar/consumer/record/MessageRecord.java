package com.pulsar.consumer.record;

import com.pulsar.consumer.dto.User;

public record MessageRecord(Long id, User user){
}
