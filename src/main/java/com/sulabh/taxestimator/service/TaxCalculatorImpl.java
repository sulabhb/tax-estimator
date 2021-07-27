package com.sulabh.taxestimator.service;

import org.springframework.stereotype.Service;

@Service
public class TaxCalculatorImpl implements TaxCalculator {

    public double calculateIncomeTax(double taxableIncome){

        if(taxableIncome > 0 && taxableIncome <= 18200){
            return 0;
        }else if (taxableIncome > 18200 && taxableIncome <= 45000){
            return (taxableIncome - 18200) * .19;
        }else if (taxableIncome > 45000 && taxableIncome <= 120000){
            return ((taxableIncome - 45000) * .325) + 5092;
        }else if (taxableIncome > 120000 && taxableIncome <= 180000){
            return ((taxableIncome - 120000) * .37) + 29467;
        }else if (taxableIncome > 180000){
            return ((taxableIncome - 180000) * .45) + 51667;
        }else{
            return 0;
        }
    }
}
