package org.selfiepro.client.mvc.services;

import java.net.URI;
import java.util.List;

import javax.inject.Inject;

import org.selfiepro.client.mvc.model.Contest;
import org.selfiepro.client.mvc.model.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@Service
public class SelfieProService {

	private static final String BASE = "http://selfiepro.herokuapp.com/api/client/products/";

	private static final String PRODUCTS_LIST = BASE + "list";
	
	private static final String PRODUCTS_ADD = BASE + "add";
	
	private static final String CONTESTS_ADD = BASE + "add";
	
	@Inject
	@Qualifier("trustedClientRestTemplate")
	private RestTemplate operations;
	

	public String saveProduct(String name, String price) {
		HttpHeaders headers = new HttpHeaders();
	    headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
	    headers.add("Content-type", MediaType.APPLICATION_JSON_VALUE);
	    String jsonString = "{\"name\": \"prod2\"}";
	    HttpEntity<String> request = new HttpEntity<String>(jsonString, headers);
	    HttpEntity<String> request2 = new HttpEntity<String>(headers);
	    
	    operations.postForEntity(URI.create(PRODUCTS_ADD), request , String.class);
	    ResponseEntity<String> exchange = operations.exchange(URI.create(PRODUCTS_LIST), HttpMethod.GET, request2 , String.class);
	    
	    System.out.println(exchange.getBody());
		return " ";
	}
	
	public HttpStatus saveProduct(Product product){
		HttpHeaders headers = new HttpHeaders();
	    headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
	    headers.add("Content-type", MediaType.APPLICATION_JSON_VALUE);
	    String jsonString = "{\"name\": \"%s\", \"price\": %s, \"exId\": %s, \"imageUrl\": \"%s\"}";
	    String finalJson = String.format(jsonString, product.getName(), product.getPrice(), product.getId(), product.getImageUrl());
	    HttpEntity<String> request = new HttpEntity<String>(finalJson, headers);
	    ResponseEntity<String> responseEntity = operations.postForEntity(URI.create(PRODUCTS_ADD), request , String.class);
	    return responseEntity.getStatusCode();
	}

	public List<Product> findAllPromotedProducts() {
		HttpHeaders headers = new HttpHeaders();
	    headers.add("Content-type", MediaType.APPLICATION_JSON_VALUE);
	    HttpEntity<String> request = new HttpEntity<String>(headers);
	    
	    ParameterizedTypeReference<List<Product>> typeRef = new ParameterizedTypeReference<List<Product>>() {};
	    ResponseEntity<List<Product>> exchange = operations.exchange(URI.create(PRODUCTS_LIST), HttpMethod.GET, request , typeRef);
	    
	    return exchange.getBody();
	}
	
	public HttpStatus saveContest(Contest contest){
		return null;
	}
	
	public RestOperations getOperations() {
		return operations;
	}
	
	public void setOperations(RestTemplate operations) {
		this.operations = operations;
	}
}
