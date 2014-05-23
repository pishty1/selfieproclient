package org.selfiepro.client.mvc.repos;

import org.selfiepro.client.mvc.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {

}
