package org.selfiepro.client.mvc.services;

import java.net.URI;

import javax.inject.Inject;

import org.selfiepro.client.mvc.model.Product;
import org.springframework.beans.factory.annotation.Qualifier;
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

	private static final String PRODUCTS_URL = "http://selfiepro.herokuapp.com/api/client/products/list";
	
	private static final String PRODUCTS_ADD = "http://selfiepro.herokuapp.com/api/client/products/add";
	
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
	    ResponseEntity<String> exchange = operations.exchange(URI.create(PRODUCTS_URL), HttpMethod.GET, request2 , String.class);
	    
	    System.out.println(exchange.getBody());
		return " ";
	}
	
	public HttpStatus saveProduct(Product product){
		HttpHeaders headers = new HttpHeaders();
	    headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
	    headers.add("Content-type", MediaType.APPLICATION_JSON_VALUE);
	    String jsonString = "{\"name\": \"%s\", \"price\": %s, \"exId\": %s}";
	    String finalJson = String.format(jsonString, product.getName(), product.getPrice(), product.getId());
	    HttpEntity<String> request = new HttpEntity<String>(finalJson, headers);
	    ResponseEntity<String> responseEntity = operations.postForEntity(URI.create(PRODUCTS_ADD), request , String.class);
	    return responseEntity.getStatusCode();
	}

	public RestOperations getOperations() {
		return operations;
	}

	public void setOperations(RestTemplate operations) {
		this.operations = operations;
	}
}