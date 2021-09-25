package com.thanthu.breweryclient.web.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.URI;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.thanthu.breweryclient.web.model.BeerDto;

@SpringBootTest
class BreweryClientTest {

	@Autowired
	BreweryClient client;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testGetBeerById() {
		BeerDto dto = client.getBeerById(UUID.randomUUID());

		assertNotNull(dto);
	}

	@Test
	void testSaveNewBeer() {
		// given
		BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();

		URI uri = client.saveNewBeer(beerDto);

		assertNotNull(uri);

		System.out.println(uri.toString());

	}

	@Test
	void testUpdateBeer() {
		// given
		BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();

		client.updateBeer(UUID.randomUUID(), beerDto);

	}

}
