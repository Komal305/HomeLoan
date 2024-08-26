package com.cg.homeLoan;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.homeLoan.services.EmiCalculatorService;

@SpringBootTest
public class EmiCalculatorServiceTest {

    @Autowired
    private EmiCalculatorService emiCalculatorService;

//    @Test
//    public void testCalculateEmi() {
//        Double emi = emiCalculatorService.CalculateEmi(5000000.0, 7.5, 240);
//        assertEquals(40288.29, emi, 0.01);
//    }
}
