package com.harshad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.harshad.model.BillingDetails;
import com.harshad.service.BillingDetailsService;

@Controller
public class BillingDetailsController {

    @Autowired
    private BillingDetailsService billingDetailsService;

    @GetMapping("/billing-details")
    public String showBillingDetailsForm(Model model) {
        model.addAttribute("billingDetails", new BillingDetails());
        return "checkout";
    }

    @PostMapping("/billing-details/save")
    public String saveBillingDetails(@ModelAttribute("billingDetails") BillingDetails billingDetails,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "checkout";
        }
        billingDetailsService.saveBillingDetails(billingDetails);
        return "redirect:/checkout";
    }
}
