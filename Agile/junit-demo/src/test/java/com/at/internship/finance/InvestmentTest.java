package com.at.internship.finance;

import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class InvestmentTest {
    private Investment investment;

    @Test
    public void testGetFinalCapital() {
        //End of first year = 110;
        //End of second year = 121;
        //End of third year = 133.1
        Assertions.assertEquals(new BigDecimal("133.10"), investment.getFinalCapital(3).setScale(2,RoundingMode.HALF_UP));
    }

    @Test
    public void testGetYield() {
        //End of first year = 110;
        //End of second year = 121;
        //End of third year = 133.1

        Assertions.assertEquals(new BigDecimal("33.10"), investment.getYield(3).setScale(2, RoundingMode.HALF_UP));
    }
    @BeforeEach
    public void beforeEach(){
        System.out.println("Before each test");
        investment = new Investment(new BigDecimal("100.00"), new BigDecimal("0.10"));
    }

    @AfterAll
    static void afterEach(){
        System.out.println("After all test");
    }

    @BeforeEach
    public void beforeAll(){
        System.out.println("Before all test");
    }

    @Test
    public void testValidatePeriodCountProvideNegative(){
        IllegalArgumentException e = Assertions.assertThrows(
                IllegalArgumentException.class,
                ()-> investment.validatePeriodCount(0)
        );
        Assertions.assertEquals("The number of periods should be 1 at minimum",e.getMessage());
    }

    @Test
    @Disabled
    public void testValidatePeriodCountProvidePositive(){
        IllegalArgumentException e = Assertions.assertThrows(
                IllegalArgumentException.class,
                ()-> investment.validatePeriodCount(5)
        );
    }

}
