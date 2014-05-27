package org.selfiepro.client.mvc.controllers;

import java.util.List;

import javax.inject.Inject;

import org.selfiepro.client.mvc.model.Contest;
import org.selfiepro.client.mvc.model.Product;
import org.selfiepro.client.mvc.services.MainService;
import org.selfiepro.client.mvc.services.SelfieProService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/admin")
public class Admincontroller {

	@Inject
	private SelfieProService proService;
	
	@Inject
	private MainService mainService;
	
	
	@RequestMapping(value = "/promote", method = RequestMethod.GET)
	public String home(Model model) {
		
		List<Product> products = mainService.getProducts();
		model.addAttribute("products", products);

		return "promotehome";
	}
	
	@RequestMapping(value = "/promote/{id}", method = RequestMethod.POST)
	public String promoteProduct(@PathVariable("id") Integer prodId, Model model) {
		Product product = mainService.findProduct(prodId);
		HttpStatus createStatus = proService.saveProduct(product);
		
		if(createStatus == HttpStatus.CREATED) {
			product.setStatus("promoted");
			mainService.saveProduct(product);
		}
		
		return "redirect:/admin/promote";
	}
	
	@RequestMapping(value = "/contests", method = RequestMethod.GET)
	public String contestsHome(Model model) {
		List<Product> products = proService.findAllPromotedProducts();
		Contest contest = new Contest();
		model.addAttribute("contest", contest);
		model.addAttribute("sfProducts", products);
		return "contestshome";
	}
	
	@RequestMapping(value = "/contests/add", method = RequestMethod.GET)
	public String addContests(Contest contest, Model model) {
		proService.saveContest(contest);
		List<Product> products = proService.findAllPromotedProducts();
		model.addAttribute("sfProducts", products);
		return "contestshome";
	}
	
	
}
