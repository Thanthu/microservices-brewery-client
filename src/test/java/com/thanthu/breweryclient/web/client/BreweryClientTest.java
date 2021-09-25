package com.thanthu.breweryclient.web.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.URI;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.thanthu.breweryclient.web.model.BeerDto;
import com.thanthu.breweryclient.web.model.CustomerDto;

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

	@Test
	void getCustomerById() {
		CustomerDto dto = client.getCustomerById(UUID.randomUUID());

		assertNotNull(dto);

	}

	@Test
	void testSaveNewCustomer() {
		// given
		CustomerDto customerDto = CustomerDto.builder().name("Joe").build();

		URI uri = client.saveNewCustomer(customerDto);

		assertNotNull(uri);

		System.out.println(uri.toString());

	}

	@Test
	void testUpdateCustomer() {
		// given
		CustomerDto customerDto = CustomerDto.builder().name("Jim").build();

		client.updateCustomer(UUID.randomUUID(), customerDto);

	}

	@Test
	void testDeleteCustomer() {
		client.deleteCustomer(UUID.randomUUID());
	}

	@Test
	void testDeleteBeer() {
		client.deleteBeer(UUID.randomUUID());
	}

}
