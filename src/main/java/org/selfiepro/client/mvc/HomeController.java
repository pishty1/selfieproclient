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
package org.selfiepro.client.mvc;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.FacebookProfile;
import org.springframework.social.facebook.api.FeedOperations;
import org.springframework.social.facebook.api.GeneralActions;
import org.springframework.social.facebook.api.OpenGraphOperations;
import org.springframework.social.facebook.api.Page;
import org.springframework.social.facebook.api.PostData;
import org.springframework.social.facebook.api.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Simple little @Controller that invokes Facebook and renders the result.
 * The injected {@link Facebook} reference is configured with the required authorization credentials for the current user behind the scenes.
 * @author Keith Donald
 */
@Controller
public class HomeController {
	
	

	private final Facebook facebook;
	private final PenService penService;
	private final UserService userService;
	private final BrushService brushService;
	private final FileService fileService;
	
	private User user;
	
	@Inject
	public HomeController(Facebook facebook, PenService penService, UserService userService, 
			BrushService brushService, FileService fileService) {
		this.facebook = facebook;
		this.penService = penService;
		this.userService = userService;
		this.brushService = brushService;
		this.fileService = fileService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		List<Reference> friends = facebook.friendOperations().getFriends();
		FacebookProfile userProfile = facebook.userOperations().getUserProfile();
		
		if(userService.userExists(userProfile.getId())) {
			System.out.println("the user exist");
			userService.getUser(userProfile.getId());
		}else {
			System.out.println("the user doesnt exist");
			user = new User();
			user.setId(userProfile.getId());
			userService.saveUser(user);
		}
		
		System.out.println("firends size is " +friends.size() + " user id is =" + user.getId());
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
	
	
	@RequestMapping(value = "/pen/{penId}", method = RequestMethod.GET)
	public String getpen(@PathVariable long penId, Model model) {
		Pen pen = penService.getPen(penId);
		
		model.addAttribute("currentUserId", user.getId());
		model.addAttribute("Pen", pen);
		return "pendetails";
	}
	
	@RequestMapping(value = "/brush", method = RequestMethod.GET)
	public String brush(Model model) {
		List<Pen> allPens = penService.getAllPens();
		System.out.println("we have " + allPens.size());
		model.addAttribute("pens", allPens);
		return "brush";
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
	
	
	
	@RequestMapping(value = "/submitPen", method = RequestMethod.GET)
	public RedirectView submitw(@ModelAttribute("Pen") Pen pen, BindingResult result, ModelMap model) {
		System.out.println(pen.getWrite());
		
		pen.setUser(user);
		penService.savePen(pen);
		Page page = facebook.pageOperations().getPage("ratemenowbabes");
		System.out.println(page.getAbout());
		FeedOperations feedOperations = facebook.feedOperations();
		feedOperations.post("ratemenowbabes", page.getAbout());
		
		System.out.println(pen.getId());
		return new RedirectView("brush");
	}
	
	@RequestMapping(value = "submitBrush", method = RequestMethod.POST, headers = "content-type=multipart/*")
	public RedirectView submitB(@RequestParam("file") MultipartFile file, @RequestParam("penId") String penId, Model model) throws IOException {
		fileService.saveFile(file, penId + "_" + user.getId());
		return new RedirectView("brush");
	}
	
	
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String home1(Model model) {
		List<Reference> friends = facebook.friendOperations().getFriends();
		model.addAttribute("friends", friends);
		return "home";	
	}

}
