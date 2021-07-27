package com.sulabh.taxestimator.model;

import org.springframework.stereotype.Component;

@Component
public class Taxation {

    private double grossSalaryIncome;
    //private double otherIncome;
    //private double totalDeductions;
    private double withheldTax;
    //private String isMedicare;
    private double totalTax;
    private double taxReturn;

    public Taxation() {
    }

    public double getGrossSalaryIncome() {
        return grossSalaryIncome;
    }

    public void setGrossSalaryIncome(double grossSalaryIncome) {
        this.grossSalaryIncome = grossSalaryIncome;
    }

    public double getWithheldTax() {
        return withheldTax;
    }

    public void setWithheldTax(double withheldTax) {
        this.withheldTax = withheldTax;
    }

    public double getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(double totalTax) {
        this.totalTax = totalTax;
    }

    public double getTaxReturn() {
        return this.getTotalTax() - this.getWithheldTax();
    }

}

