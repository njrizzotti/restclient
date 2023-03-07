package com.rizzotti.restclient;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;
import java.util.concurrent.CompletableFuture;

@SpringBootApplication
public class RestclientApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(RestclientApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public CommandLineRunner run(PaymentService paymentService) {
		return args -> {
			paymentService.call(Integer.valueOf(args[0]));
		};
	}

}

