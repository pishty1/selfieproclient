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
package org.springframework.social.quickstart;

import java.util.List;

import javax.inject.Inject;

import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@Inject
	public HomeController(Facebook facebook) {
		this.facebook = facebook;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		List<Reference> friends = facebook.friendOperations().getFriends();
		System.out.println("firends size is " +friends.size());
//		int counter = 0;
//		for (Reference reference : friends) {
//			FacebookProfile userProfile = facebook.userOperations().getUserProfile(reference.getId());
//			String email = userProfile.getEmail();
//			System.out.println(counter++ + ") email is ====== " +email);
//		}
		model.addAttribute("friends", friends);
		return "home";
	}
	
	@RequestMapping(value = "/bidwithcoins", method = RequestMethod.GET)
	public String bidCoins(Model model) {
		return "bidHome";
	}
	
	@RequestMapping(value = "/pen", method = RequestMethod.GET)
	public String pen(Model model) {
		model.addAttribute("Pen", new Pen());
		return "pen";
	}
	
	@RequestMapping(value = "/brush", method = RequestMethod.GET)
	public String brush(Model model) {
		return "brush";
	}
	
	@RequestMapping(value = "/account", method = RequestMethod.GET)
	public String account(Model model) {
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
	
	
	
	@RequestMapping(value = "/submitw", method = RequestMethod.GET)
	public String submitw(@ModelAttribute("Pen") Pen pen, BindingResult result, ModelMap model) {
		System.out.println(pen.getWrite());
		return "brush";
	}
	
	
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String home1(Model model) {
		List<Reference> friends = facebook.friendOperations().getFriends();
		model.addAttribute("friends", friends);
		return "home";
	}

}
