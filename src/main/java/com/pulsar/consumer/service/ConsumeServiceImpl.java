package com.pulsar.consumer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pulsar.consumer.dto.User;
import com.pulsar.consumer.record.MessageRecord;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.pulsar.client.api.Consumer;
import org.apache.pulsar.client.api.Message;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ConsumeServiceImpl implements ConsumeService {

    private static final String TEST_REQUEST_TOPIC = "test-request-topic";
    private final PulsarClient pulsarClient;
    private final UserService userService;

    @PostConstruct
    public void init() throws PulsarClientException, JsonProcessingException {
        Consumer<byte[]> consumer = pulsarClient.newConsumer()
                .topic(TEST_REQUEST_TOPIC)
                .subscriptionName("test-request-topic")
                .subscribe();

        while (true) {
            Message<byte[]> message = consumer.receive();
            String strMsg = new String(message.getValue());
            ObjectMapper objectMapper = new ObjectMapper();
            MessageRecord messageRecord = objectMapper.readValue(strMsg, MessageRecord.class);
            log.info("Got message: " + messageRecord);
            consumer.acknowledge(message);

            User user = this.userService.saveNew(messageRecord.user());
            log.info("saved user: " + user);
        }

    }
}
