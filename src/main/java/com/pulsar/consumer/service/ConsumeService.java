package com.pulsar.consumer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.pulsar.client.api.PulsarClientException;

public interface ConsumeService {
    void init() throws PulsarClientException, JsonProcessingException;
}
