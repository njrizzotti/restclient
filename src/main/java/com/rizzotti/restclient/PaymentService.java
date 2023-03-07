package com.rizzotti.restclient;

import com.rizzotti.restclient.dto.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class PaymentService {

    @Autowired
    Utils utils;

    public void call(int numberOfCalls) {
        String requestBodyJson = "{\r\n    \"currency\": \"USD\",\r\n    \"amount\": 1000.50,\r\n    \"originator\": {\r\n        \"name\": \"nicolas\",\r\n        \"id\": \"1234\"\r\n    },\r\n    \"beneficiary\": {\r\n        \"name\": \"luli\",\r\n        \"id\": \"5678\"\r\n    },\r\n    \"sender\": {\r\n        \"accountType\": \"CA\",\r\n        \"accountNumber\": \"123456789\"\r\n    },\r\n    \"receiver\": {\r\n        \"accountType\": \"CA\",\r\n        \"accountNumber\": \"987654321\"\r\n    }\r\n}";
        // Create an HTTP client
        HttpClient client = HttpClient.newHttpClient();



        // Create a list to hold the CompletableFuture objects
        List<CompletableFuture<HttpResponse<String>>> futures = new ArrayList<>();

        // Send API requests in parallel and add the CompletableFuture objects to the list
        for (int i = 0; i < numberOfCalls; i++) {
            // Create an API request to the same endpoint
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8080/payments"))
                    .header("Content-Type", "application/json")
                    .header("idempotent-key", String.valueOf(UUID.randomUUID()))
                    .POST(HttpRequest.BodyPublishers.ofString(utils.createDtoToSend(i)))
                    .build();

            CompletableFuture<HttpResponse<String>> future = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
            futures.add(future);
        }

        // Process API responses as they arrive
        for (CompletableFuture<HttpResponse<String>> future : futures) {
            future.thenAccept(response -> {
                System.out.println("API call status: " + response.statusCode());
                System.out.println("API call response body: " + response.body());
            });
        }

        // Continue with other tasks without waiting for API calls to complete
        System.out.println("Continuing with other tasks...");
    }
}
