package com.thanthu.breweryclient.web.client;

import java.net.URI;
import java.util.UUID;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.thanthu.breweryclient.web.model.BeerDto;
import com.thanthu.breweryclient.web.model.CustomerDto;

@ConfigurationProperties(prefix = "brewery", ignoreUnknownFields = false)
@Component
public class BreweryClient {

	public final String BEER_PATH_V1 = "/api/v1/beer/";
	public final String CUSTOMER_PATH_V1 = "/api/v1/customer/";

	private String apihost;
	private final RestTemplate restTemplate;

	public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	public void setApihost(String apihost) {
		this.apihost = apihost;
	}

	public BeerDto getBeerById(UUID uuid) {
		return restTemplate.getForObject(apihost + BEER_PATH_V1 + uuid, BeerDto.class);
	}

	public URI saveNewBeer(BeerDto beerDto) {
		return restTemplate.postForLocation(apihost + BEER_PATH_V1, beerDto);
	}

	public void updateBeer(UUID uuid, BeerDto beerDto) {
		restTemplate.put(apihost + BEER_PATH_V1 + uuid, beerDto);
	}

	public void deleteBeer(UUID uuid) {
		restTemplate.delete(apihost + BEER_PATH_V1 + uuid);
	}

	public CustomerDto getCustomerById(UUID customerId) {
		return restTemplate.getForObject(apihost + CUSTOMER_PATH_V1 + customerId.toString(), CustomerDto.class);
	}

	public URI saveNewCustomer(CustomerDto customerDto) {
		return restTemplate.postForLocation(apihost + CUSTOMER_PATH_V1, customerDto);
	}

	public void updateCustomer(UUID customerId, CustomerDto customerDto) {
		restTemplate.put(apihost + CUSTOMER_PATH_V1 + customerId, customerDto);
	}

	public void deleteCustomer(UUID customerId) {
		restTemplate.delete(apihost + CUSTOMER_PATH_V1 + customerId);
	}

}
