package com.sulabh.taxestimator;

import com.sulabh.taxestimator.service.TaxCalculatorImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TaxEstimatorApplicationTests {

    @Autowired
    TaxCalculatorImpl taxCalculator;

    @Test
    void testCalculateIncomeTaxBelow18200(){
        Assertions.assertEquals(0,taxCalculator.calculateIncomeTax(18000));
    }

    @Test
    void testCalculateIncomeTaxAbove18200to45000(){
        Assertions.assertEquals(Math.ceil(4554.68),Math.ceil(taxCalculator.calculateIncomeTax(42172)));
    }

    @Test
    void testCalculateIncomeTaxAbove45000to12000(){
        Assertions.assertEquals(5092,taxCalculator.calculateIncomeTax(45000));
    }

}
