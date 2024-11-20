package com.demo.springlocalstack.service;

import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.springlocalstack.dto.input.CustomerSqsInput;
import com.demo.springlocalstack.dto.output.CustomerSqsOutput;
import com.demo.springlocalstack.model.Customer;
import com.demo.springlocalstack.repository.SqsRepositoryInterface;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import software.amazon.awssdk.services.sqs.model.Message;

@Service
public class CustomerService {

    @Autowired
    SqsRepositoryInterface sqsRepository;

    public void registerToSqs(CustomerSqsInput customerSqsInput) {
        Customer customer = new Customer(
            customerSqsInput.getName(),
            customerSqsInput.getAddress(),
            customerSqsInput.getAge(),
            LocalDate.parse(customerSqsInput.getJoinDate()),
            customerSqsInput.getGender(),
            customerSqsInput.getOccupation()
        );

        sqsRepository.sendMessage(customer.toString());
    }

    public List<CustomerSqsOutput> receiveMessageFromSqs() {
        List<Message> messages = sqsRepository.receiveMessagaes();
        List<CustomerSqsOutput> customerSqsOutputList =  messages.stream().map((msg) -> jsonToObj(msg.body())).collect(Collectors.toList());

        return customerSqsOutputList;
    }

    private static CustomerSqsOutput jsonToObj(String jsonString) {
        if (jsonString == null) return null;

        ObjectMapper objectMapper = new ObjectMapper();
        CustomerSqsOutput customerSqsOutput = new CustomerSqsOutput();
        try {
            JsonNode jsonNode = objectMapper.readTree(jsonString);
            customerSqsOutput.setName(jsonNode.get("name").asText());
            customerSqsOutput.setAddress(jsonNode.get("address").asText());
            customerSqsOutput.setAge(jsonNode.get("age").asInt());
            customerSqsOutput.setJoinDate(jsonNode.get("join_date").asText());
            customerSqsOutput.setGender(jsonNode.get("gender").asText());
            customerSqsOutput.setOccupation(jsonNode.get("occupation").asText());
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return customerSqsOutput;
    }
}
