package com.sulabh.taxestimator;

import com.sulabh.taxestimator.service.OffSetCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OffsetCalculatorTest {

    @Autowired
    OffSetCalculator offSetCalculator;


    @Test
    public void lowOffsetCalculatorTest(){
        Assertions.assertEquals(466.4,offSetCalculator.lowIncomeTaxOffsetCalculator(42172));
    }

    @Test
    public void lowOffsetCalculatorTestAbove66667(){
        Assertions.assertEquals(0,offSetCalculator.lowIncomeTaxOffsetCalculator(66667));
    }

    @Test
    public void lowAndMiddleOffsetCalculatorTest(){
        Assertions.assertEquals(Math.ceil(643), Math.ceil(offSetCalculator.lowAndMiddleTaxOffsetCalculator(42172)));
    }
}
