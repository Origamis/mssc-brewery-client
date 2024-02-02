package com.spring.andrius.msscbreweryclient.client;

import com.spring.andrius.msscbreweryclient.web.model.CustomerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "sfg.brewery", ignoreUnknownFields = false)
public class CustomerClient {

    public static final String BEER_PATH_V1 = "/api/v1/customer/";
    private String apiHost;
    private final RestTemplate restTemplate;

    public CustomerClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public CustomerDto getCustomerById(UUID id) {
        return restTemplate.getForObject(apiHost + BEER_PATH_V1 + id.toString(), CustomerDto.class);
    }

    public URI saveNewCustomer(CustomerDto customerDto) {
        return restTemplate.postForLocation(apiHost + BEER_PATH_V1, customerDto);
    }

    public void updateCustomer(UUID id, CustomerDto customerDto) {
        restTemplate.put(apiHost + BEER_PATH_V1 + id, customerDto);
    }

    public void deleteCustomer(UUID id) {
        restTemplate.delete(apiHost + BEER_PATH_V1 + id);
    }

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }
}
