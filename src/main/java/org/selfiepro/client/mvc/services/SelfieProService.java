package org.selfiepro.client.mvc.services;

import org.selfiepro.client.mvc.model.Contest;
import org.selfiepro.client.mvc.model.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;

import java.net.URI;
import java.util.List;

@Service
public class SelfieProService {

  private static final String BASE = "http://selfiepro.herokuapp.com/api/client/";

  private static final String PROD = BASE + "products/";

  private static final String PRODUCTS_LIST = PROD + "list";

  private static final String PRODUCTS_ADD = PROD + "add";
  private static final String CONTESTS_ADD = PROD + "%s/contests/add";
  private static final String CONTEST = BASE + "contests/";
  private static final String CONTESTS_LIST = CONTEST + "list";
  private static final String PARTICIPANT_ADD = CONTEST;

  @Inject
  @Qualifier("trustedClientRestTemplate")
  private RestTemplate operations;

  public String saveProduct(String name, String price) {
    HttpHeaders headers = new HttpHeaders();
    headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
    headers.add("Content-type", MediaType.APPLICATION_JSON_VALUE);
    String jsonString = "{\"name\": \"prod2\"}";
    HttpEntity<String> request = new HttpEntity<>(jsonString, headers);
    HttpEntity<String> request2 = new HttpEntity<>(headers);

    operations.postForEntity(URI.create(PRODUCTS_ADD), request, String.class);
    ResponseEntity<String> exchange = operations.exchange(URI.create(PRODUCTS_LIST), HttpMethod.GET, request2,
                                                          String.class);

    System.out.println(exchange.getBody());
    return " ";
  }

  public HttpStatus saveProduct(Product product) {
    HttpHeaders headers = new HttpHeaders();
    headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
    headers.add("Content-type", MediaType.APPLICATION_JSON_VALUE);
    String jsonString = "{\"name\": \"%s\", \"price\": %s, \"exId\": %s, \"imageUrl\": \"%s\"}";
    String finalJson = String.format(jsonString, product.getName(), product.getPrice(), product.getId(), product.getImageUrl());
    HttpEntity<String> request = new HttpEntity<>(finalJson, headers);
    ResponseEntity<String> responseEntity = operations.postForEntity(URI.create(PRODUCTS_ADD), request,
                                                                     String.class);
    return responseEntity.getStatusCode();
  }

  public HttpStatus saveContest(Contest contest) {
    String contestAdd = String.format(CONTESTS_ADD, contest.getProductId());
    HttpHeaders headers = new HttpHeaders();
    headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
    headers.add("Content-type", MediaType.APPLICATION_JSON_VALUE);
    String jsonString = "{\"name\": \"%s\", \"fbPageName\": \"%s\", \"maxParticipants\": %s}";
    String finalJson = String.format(jsonString, contest.getName(), contest.getFbPageName(),
                                     contest.getMaxParticipants());
    HttpEntity<String> request = new HttpEntity<>(finalJson, headers);
    ResponseEntity<String> responseEntity = operations.postForEntity(URI.create(contestAdd), request, String.class);
    return responseEntity.getStatusCode();
  }


  public List<Product> findAllPromotedProducts() {
    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-type", MediaType.APPLICATION_JSON_VALUE);
    HttpEntity<String> request = new HttpEntity<>(headers);

    ParameterizedTypeReference<List<Product>> typeRef = new ParameterizedTypeReference<List<Product>>() {
    };
    ResponseEntity<List<Product>> exchange = operations.exchange(URI.create(PRODUCTS_LIST), HttpMethod.GET,
                                                                 request, typeRef);

    return exchange.getBody();
  }

  public List<Contest> findAllContests() {
    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-type", MediaType.APPLICATION_JSON_VALUE);
    HttpEntity<String> request = new HttpEntity<>(headers);

    ParameterizedTypeReference<List<Contest>> typeRef = new ParameterizedTypeReference<List<Contest>>() {
    };
    ResponseEntity<List<Contest>> exchange = operations.exchange(URI.create(CONTESTS_LIST), HttpMethod.GET,
                                                                 request, typeRef);
    return exchange.getBody();
  }

  public void enterContest(Integer contestId, Integer partId) {

    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-type", MediaType.APPLICATION_JSON_VALUE);
    HttpEntity<String> request = new HttpEntity<>(headers);

    ResponseEntity<String> exchange = operations.exchange(URI.create(CONTESTS_LIST), HttpMethod.GET,
                                                          request, String.class);



  }

  public RestOperations getOperations() {
    return operations;
  }

  public void setOperations(RestTemplate operations) {
    this.operations = operations;
  }
}
