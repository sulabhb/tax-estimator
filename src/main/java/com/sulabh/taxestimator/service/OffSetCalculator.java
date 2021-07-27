package com.sulabh.taxestimator.service;

public interface OffSetCalculator {
    double lowIncomeTaxOffsetCalculator(double taxableIncome);
    double lowAndMiddleTaxOffsetCalculator(double taxableIncome);
}
