package com.demo.springlocalstack.repository;

import java.util.List;

import software.amazon.awssdk.services.sqs.model.Message;

public interface SqsRepositoryInterface {
    public void sendMessage(String message);

    public List<Message> receiveMessagaes();
}
