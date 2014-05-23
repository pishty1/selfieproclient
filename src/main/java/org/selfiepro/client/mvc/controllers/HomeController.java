/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.selfiepro.client.mvc.controllers;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.selfiepro.client.mvc.model.Product;
import org.selfiepro.client.mvc.services.ProductService;
import org.selfiepro.client.mvc.services.SelfieProService;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.FacebookProfile;
import org.springframework.social.facebook.api.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Simple little @Controller that invokes Facebook and renders the result.
 * The injected {@link Facebook} reference is configured with the required authorization credentials for the current user behind the scenes.
 * @author Keith Donald
 */
@Controller
public class HomeController {
	
	

	private final Facebook facebook;
	private final ProductService productService;
	private final SelfieProService selfieProService;
	
	
	@Inject
	public HomeController(Facebook facebook, ProductService productService, SelfieProService selfieProService) {
		this.facebook = facebook;
		this.productService = productService;
		this.selfieProService = selfieProService;
		this.productService.generateTestData();
	}

//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String home(Model model) {
//		List<Reference> friends = facebook.friendOperations().getFriends();
//		FacebookProfile userProfile = facebook.userOperations().getUserProfile();
//		
//		if(userService.userExists(userProfile.getId())) {
//			System.out.println("the user exist");
//			userService.getUser(userProfile.getId());
//		}else {
//			System.out.println("the user doesnt exist");
//			user = new User();
//			user.setId(userProfile.getId());
//			userService.saveUser(user);
//		}
//		
//		System.out.println("firends size is " +friends.size() + " user id is =" + user.getId());
////		int counter = 0;
////		for (Reference reference : friends) {
////			FacebookProfile userProfile = facebook.userOperations().getUserProfile(reference.getId());
////			String email = userProfile.getEmail();
////			System.out.println(counter++ + ") email is ====== " +email);
////		}
//		model.addAttribute("friends", friends);
//		return "home";
//	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		List<Product> products = productService.getProducts();
		model.addAttribute("products", products);
		return "home";
	}
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String products(Map<String, Object> model) {
		selfieProService.saveProduct("prod1", "ldjkf");
		List<Product> products = productService.getProducts();
		model.put("products", products);
		return "productshome";
	}
	
	@RequestMapping(value = "/products/{id}/promote", method = RequestMethod.GET)
	public String promoteProduct(@PathVariable("id") Integer prodId, Map<String, Object> model) {
		Product product = productService.findProduct(prodId);
		product.setStatus("promoted");
		productService.saveProduct(product);
		return "redirect:/products";
	}
	
	@RequestMapping(value = "/account", method = RequestMethod.GET)
	public String account(Model model) {
		FacebookProfile userProfile = facebook.userOperations().getUserProfile();
		model.addAttribute("userName", userProfile.getName());
		return "account";
	}
	
	@RequestMapping(value = "/sign", method = RequestMethod.GET)
	public String signin(Model model) {
		return "sign";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(Model model) {
		return "signup";
	}
	
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String home1(Model model) {
		List<Reference> friends = facebook.friendOperations().getFriends();
		model.addAttribute("friends", friends);
		return "home";	
	}

}
