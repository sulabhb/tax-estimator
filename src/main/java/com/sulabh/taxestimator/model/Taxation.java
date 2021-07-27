package com.sulabh.taxestimator.model;

import org.springframework.stereotype.Component;

@Component
public class Taxation {

    private double grossSalaryIncome;
    private double otherIncome;
    private double totalDeductions;
    private double taxableIncome;
    private double withheldTax;
    //private String isMedicare;
    private double totalTax;
    private double taxReturn;

    private double lowIncomeTaxOffset;
    private double lowAndMiddleIncomeTaxOffset;

    public Taxation() {
    }

    public double getLowIncomeTaxOffset() {
        return lowIncomeTaxOffset;
    }

    public void setLowIncomeTaxOffset(double lowIncomeTaxOffset) {
        this.lowIncomeTaxOffset = lowIncomeTaxOffset;
    }

    public double getLowAndMiddleIncomeTaxOffset() {
        return lowAndMiddleIncomeTaxOffset;
    }

    public void setLowAndMiddleIncomeTaxOffset(double lowAndMiddleIncomeTaxOffset) {
        this.lowAndMiddleIncomeTaxOffset = lowAndMiddleIncomeTaxOffset;
    }

    public double getOtherIncome() {
        return otherIncome;
    }

    public void setOtherIncome(double otherIncome) {
        this.otherIncome = otherIncome;
    }

    public void setTotalDeductions(double totalDeductions) {
        this.totalDeductions = totalDeductions;
    }

    public double getTotalDeductions() {
        return totalDeductions;
    }

    public double getTaxableIncome() {
        return this.grossSalaryIncome + this.otherIncome - this.totalDeductions;
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
        return this.getWithheldTax() - this.totalTax + this.lowIncomeTaxOffset + this.lowAndMiddleIncomeTaxOffset;
    }

}

