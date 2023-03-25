package com.harshad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.harshad.global.GlobalData;
import com.harshad.model.Contact;
import com.harshad.service.AnimalCategoryService;
import com.harshad.service.CategoryService;
import com.harshad.service.ContactService;
import com.harshad.service.DiseaseService;
import com.harshad.service.ProductService;

@Controller
public class HomeController {

	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductService productService;
	@Autowired 
	AnimalCategoryService animalCategoryService;
	@Autowired
	DiseaseService diseaseService;

	@GetMapping({ "/", "/home" })
	public String home(Model model) {

		model.addAttribute("cartCount", GlobalData.cart.size());
		return "index";
	}

	@GetMapping("/shop")
	public String shop(Model model) {
		model.addAttribute("categories", categoryService.getAllCategories());
		model.addAttribute("products", productService.getAllProducts());
		model.addAttribute("cartCount", GlobalData.cart.size());
		return "shop";
	}

	@GetMapping("/shop/category/{id}")
	public String shopByCategory(Model model, @PathVariable int id) {
		model.addAttribute("categories", categoryService.getAllCategories());
		model.addAttribute("products", productService.getAllProductByCategoryId(id));
		model.addAttribute("cartCount", GlobalData.cart.size());
		return "shop";
	}

	@GetMapping("/shop/viewproduct/{id}")
	public String Viewshop(Model model, @PathVariable int id) {
		model.addAttribute("categories", categoryService.getAllCategories());
		model.addAttribute("products", productService.getAllProductByCategoryId(id));
		model.addAttribute("cartCount", GlobalData.cart.size());
		model.addAttribute("product", productService.getProductById(id).get());
		model.addAttribute("cartCount", GlobalData.cart.size());
		return "view";
	}
	@GetMapping({ "/contact" })
	public String contact(Model model) {

		model.addAttribute("cartCount", GlobalData.cart.size());
		return "CONTACT";
	}
	// Animal disease

@GetMapping("/disease")
public String disease(Model model) {
	model.addAttribute("animalcategories", animalCategoryService.getAllAnimalCategories());
	model.addAttribute("disease", diseaseService.getAllDisease());
	// model.addAttribute("cartCount", GlobalData.cart.size());
	return "animal";
}


@GetMapping("/disease/category/{id}")
public String diseaseByCategory(Model model, @PathVariable int id) {
	model.addAttribute("categories", animalCategoryService.getAllAnimalCategories());
	model.addAttribute("disease", diseaseService.getAllDiseaseByCategoryId(id));
	// model.addAttribute("cartCount", GlobalData.cart.size());
	return "animal";
}


@GetMapping("/disease/viewdisease/{id}")
public String Viewdisease(Model model, @PathVariable int id) {

	model.addAttribute("disease", diseaseService.getDiseaseById(id).get());
	// model.addAttribute("cartCount", GlobalData.cart.size());
	return "animal";
}

//contact
private final ContactService contactService;

public HomeController(ContactService contactService) {
    this.contactService = contactService;
}

@GetMapping("/contact-show")
public String showContact() {
	return "contact";
}

@GetMapping("/contact-form")
public String showContactForm(Model model) {
    model.addAttribute("contact", new Contact());
    return "index";
}

@PostMapping("/contact")
public String submitContactForm(@ModelAttribute("contact") Contact contact) {
    contactService.save(contact);
    return "redirect:/";
}
	
}
