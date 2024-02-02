package com.spring.andrius.msscbreweryclient.client;

import com.spring.andrius.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CustomerClientTest {

    @Autowired
    CustomerClient customerClient;

    @Test
    void getCustomerById() {
        CustomerDto customerDto = customerClient.getCustomerById(UUID.randomUUID());

        assertNotNull(customerDto);
    }

    @Test
    void saveNewCustomer() {
        CustomerDto customerDto = CustomerDto.builder().name("Andrius").build();

        URI uri = customerClient.saveNewCustomer(customerDto);

        System.out.println(uri.toString());
        assertNotNull(uri);
    }

    @Test
    void updateCustomer() {
        CustomerDto customerDto = CustomerDto.builder().name("Andrius").build();

        customerClient.updateCustomer(UUID.randomUUID(), customerDto);
    }

    @Test
    void deleteCustomer() {
        customerClient.deleteCustomer(UUID.randomUUID());
    }
}