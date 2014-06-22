package org.selfiepro.client.mvc.services;

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
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

import javax.inject.Inject;

@Service
public class SelfieProService {

  private static final String BASE = "http://selfiepro.herokuapp.com/api/client/";

  private static final String PROD = BASE + "products/";

  private static final String PRODUCTS_LIST = PROD + "list";

  private static final String PRODUCTS_ADD = PROD + "add";
  private static final String CONTESTS_ADD = PROD + "%s/contests/add";
  private static final String CONTEST = BASE + "contests/";
  private static final String CONTESTS_LIST = CONTEST + "list";
  private static final String PARTICIPANT_ADD = CONTEST + "%s/participants/add";
  private static final String CONTESTS_BY_PART = BASE + "part/%s";

  @Inject
  @Qualifier("trustedClientRestTemplate")
  private RestTemplate operations;


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

    String objectJson = String.format(jsonString, contest.getName(), contest.getFbPageName(),
                                      contest.getMaxParticipants());

    HttpEntity<String> request = new HttpEntity<>(objectJson, headers);

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

  public HttpStatus enterContest(Integer contestId, Facebook facebook) {

    HttpHeaders headers = new HttpHeaders();
    headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
    headers.add("Content-type", MediaType.APPLICATION_JSON_VALUE);

    String jsonString = "{\"fname\": \"%s\","
                      + " \"lname\": \"%s\", "
                      + "\"facebookId\" : \"%s\"}";
    String postString = String.format(jsonString, 
                                      facebook.userOperations().getUserProfile().getFirstName(), 
                                      facebook.userOperations().getUserProfile().getLastName(), 
                                      facebook.userOperations().getUserProfile().getId());


    HttpEntity<String> request = new HttpEntity<>(postString, headers);

    String url = String.format(PARTICIPANT_ADD, contestId);

    ResponseEntity<String> exchange = operations.postForEntity(URI.create(url),
                                                               request, String.class);
    return exchange.getStatusCode();
  }

  public List<Contest> findContestsByFbId(String id) {
    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-type", MediaType.APPLICATION_JSON_VALUE);
    HttpEntity<String> request = new HttpEntity<>(headers);
    
    String url = String.format(CONTESTS_BY_PART, id);

    ParameterizedTypeReference<List<Contest>> typeRef = new ParameterizedTypeReference<List<Contest>>() {};
    
    ResponseEntity<List<Contest>> exchange = operations.exchange(URI.create(url), HttpMethod.GET,
                                                                 request, typeRef);

    return exchange.getBody();
  }

}
