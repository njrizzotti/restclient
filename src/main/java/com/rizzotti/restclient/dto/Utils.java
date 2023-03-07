package com.rizzotti.restclient.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Random;

@Component
public class Utils {

    public String createDtoToSend(int i){
        ObjectMapper objectMapper = new ObjectMapper();
        Payment payment = new Payment("USD", new BigDecimal(100), new Customer("originatorName", String.valueOf(i+1)), new Customer("beneficiaryName", String.valueOf(i+1000)), new Account("CA", "1234"), new Account("CA","9876"));
        try {
            return objectMapper.writeValueAsString(payment);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }
}
