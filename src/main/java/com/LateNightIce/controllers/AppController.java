package com.LateNightIce.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.LateNightIce.models.Product;
import com.LateNightIce.services.ProductService;

//@RestController for Json etc. response s
@Controller // for templates
public class AppController {
	
	
	private ProductService service;
	
	public AppController(ProductService  productService) {
		this.service = productService;
	}
	
	@RequestMapping("/")
	public String viewHomPage(Model model) {
		List<Product> listOfProducts = service.listAll();
		model.addAttribute("listOfProducts", listOfProducts);
		return "home";
	}
	
	
	@RequestMapping("/new")
	public String newProductPage(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "product_form";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if (result.hasErrors()) {
            return "product_form";
        } else {
        	service.save(product);
            return "redirect:/";
        }
	}
	
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editProduct(@PathVariable(name = "id") Long id) {
		ModelAndView m = new ModelAndView("editPage");
		
		Product product = service.get(id);
		m.addObject("product", product);
		
		return m;
	}
	
	
	@RequestMapping("/show/{id}")
	public String showProductInfo(Model model, @PathVariable("id") Long id) {
		
		Product product = service.get(id);
		model.addAttribute("product", product);
		
		return "productInfoPage";
	}
	
	@RequestMapping("/Porsche")
	public String PorschePage() {
		return "Porsche33";
	}
	
	

	/* API */
	@RequestMapping("/api/products")
	public List<Product> Index() {
		return service.listAll();
	}
	
	@RequestMapping(value="/api/products", method=RequestMethod.POST)
	public Product create(@RequestParam(value="name") String name, @RequestParam(value="price") float price ) {
		Product product = new Product(name, price);
		return service.createProduct(product);   
	}
	
	@RequestMapping(value = "/api/products/{id}", method = RequestMethod.POST)
	public Product show(@PathVariable(name = "id") Long id) {
		Product product = service.get(id);
		return product;
	}
}//end class

