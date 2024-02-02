package com.spring.andrius.msscbreweryclient.client;

import com.spring.andrius.msscbreweryclient.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient breweryClient;

    @Test
    void getBeerById() {
        BeerDto beerDto = breweryClient.getBeerById(UUID.randomUUID());

        assertNotNull(beerDto);
    }

    @Test
    void postNewBeer() {
        BeerDto beerDto = BeerDto.builder().beerName("Calsberg").build();

        URI uri = breweryClient.saveNewBeer(beerDto);

        System.out.println(uri.toString());
        assertNotNull(uri);
    }

    @Test
    void updateBeer() {
        BeerDto beerDto = BeerDto.builder().beerName("Corona Extra").build();

        breweryClient.updateBeer(UUID.randomUUID(), beerDto);
    }

    @Test
    void deleteBeer() {
        breweryClient.deleteBeer(UUID.randomUUID());
    }
}