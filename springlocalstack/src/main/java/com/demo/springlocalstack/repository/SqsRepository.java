package com.demo.springlocalstack.repository;

import java.util.List;
import java.util.ArrayList;
import java.net.URI;
import org.springframework.stereotype.Repository;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.CreateQueueRequest;
import software.amazon.awssdk.services.sqs.model.GetQueueUrlRequest;
import software.amazon.awssdk.services.sqs.model.Message;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageRequest;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageResponse;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;
import software.amazon.awssdk.services.sqs.model.SqsException;

@Repository
public class SqsRepository implements SqsRepositoryInterface {

    private final String QUEU_NAME = "customer-info-queue";

    private GetQueueUrlRequest getQueueRequest = GetQueueUrlRequest.builder().queueName(QUEU_NAME).build();

    private SqsClient sqsClient = SqsClient.builder()
            .endpointOverride(URI.create("http://localstack:4566"))
            .credentialsProvider(StaticCredentialsProvider.create(
                    AwsBasicCredentials.create("localstack-access-key", "localstack-secret-key")))
            .region(Region.AP_NORTHEAST_1)
            .build();

    private String queueUrl = sqsClient.getQueueUrl(getQueueRequest).queueUrl();

    @Override
    public void sendMessage(String message) {
        try {
            CreateQueueRequest request = CreateQueueRequest.builder().queueName(QUEU_NAME).build();
            sqsClient.createQueue(request);
            SendMessageRequest sendMessageRequest = SendMessageRequest.builder()
                    .queueUrl(queueUrl)
                    .messageBody(message)
                    .delaySeconds(5)
                    .build();

            sqsClient.sendMessage(sendMessageRequest);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } 
    }

    @Override
    public List<Message> receiveMessagaes() {
        List<Message> messages = new ArrayList<>();
        try {
            ReceiveMessageRequest receiveMessageRequest = ReceiveMessageRequest.builder()
                    .queueUrl(queueUrl).maxNumberOfMessages(5).build();

            ReceiveMessageResponse receiveMessageResponse = sqsClient.receiveMessage(receiveMessageRequest);
            return receiveMessageResponse.messages();
        } catch (SqsException exception) {
            System.err.println(exception.getMessage());
        } 

        return messages;

    }
}
