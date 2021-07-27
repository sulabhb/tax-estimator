package com.sulabh.taxestimator.controller;

import com.sulabh.taxestimator.model.Taxation;
import com.sulabh.taxestimator.service.OffSetCalculator;
import com.sulabh.taxestimator.service.TaxCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    Taxation taxation;

    @Autowired
    TaxCalculator taxCalculator;

    @Autowired
    OffSetCalculator offSetCalculator;

    @GetMapping({"/home","/"})
    public String showHomePage(Model model){
        model.addAttribute("taxation",new Taxation());
        return "home";
    }

    @PostMapping("/calculateTax")
    public String calculateTax(@ModelAttribute Taxation taxation,Model model){

        taxation.setTotalTax(taxCalculator.calculateIncomeTax(taxation.getTaxableIncome()));
        taxation.setLowIncomeTaxOffset(offSetCalculator.lowIncomeTaxOffsetCalculator(taxation.getTaxableIncome()));
        taxation.setLowAndMiddleIncomeTaxOffset(offSetCalculator.lowAndMiddleTaxOffsetCalculator(taxation.getTaxableIncome()));

        model.addAttribute("result",taxation);

        System.out.println(taxation.getTotalTax());

        return "result";
    }

}
