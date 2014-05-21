package org.selfiepro.client.mvc;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	@Inject
	ProductRepository repository;
	
	
	public List<Product> getProducts(){
		return (List<Product>) repository.findAll();
	}
	
	public Product saveProduct(Product product) {
		return repository.save(product);
	}
	
	public void generateTestData() {
		List<Product> products = new ArrayList<>();
		for (int i = 0; i < 7 ; i++){
			Product product = new Product();
			product.setName("Sunglasses" + i);
			product.setPrice("11.94");
			product.setImageUrl("https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcRpbVKqC7ILZeKA588e1lqbEigIBdJH1xeDyhpswXRPQriQpbfwRA");
			products.add(product);
		}
		System.out.println("the size of the list of products = " + products.size());
		repository.save(products);
	}

	public Product findProduct(Integer prodId) {
		return repository.findOne(prodId);
	}

}
