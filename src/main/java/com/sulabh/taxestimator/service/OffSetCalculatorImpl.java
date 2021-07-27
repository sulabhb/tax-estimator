package com.sulabh.taxestimator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OffSetCalculatorImpl implements OffSetCalculator {

    @Autowired
    TaxCalculator taxCalculator;

    @Override
    public double lowIncomeTaxOffsetCalculator(double taxableIncome){

        if(taxCalculator.calculateIncomeTax(taxableIncome) < 700){
            return 0;
        }else if (taxableIncome < 37500){
            return 700;
        }else if (taxableIncome <= 45000 && taxableIncome > 37500){
            return 700 - ((taxableIncome - 37500) * .05);
        }else if (taxableIncome < 66667 && taxableIncome > 45000){
            return 325 - ((taxableIncome - 45000) * .015);
        }

        return 0;
    }

    @Override
    public double lowAndMiddleTaxOffsetCalculator(double taxableIncome) {

        double lowIncomeOffset = this.lowIncomeTaxOffsetCalculator(taxableIncome);

        if(taxCalculator.calculateIncomeTax(taxableIncome) < lowIncomeOffset + 255){
            return 0;
        }else if (taxableIncome <= 37000){
            return 255;
        }else if (taxableIncome <= 48000 && taxableIncome > 37000){
            return 255 + ((taxableIncome - 37000) * .075);
        }else if (taxableIncome <=90000 && taxableIncome > 48000){
            return 1080;
        }else if (taxableIncome <= 126000 && taxableIncome > 90000) {
            return 1080 - ((taxableIncome - 90000) * .03);
        }

        return 0;
    }
}
