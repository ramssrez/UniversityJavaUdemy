package com.at.internship.finance;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class InvestmentTest {
    private Investment investment;

    @Test
    public void testGetFinalCapital() {
        investment = new Investment(new BigDecimal("100.00"), new BigDecimal("0.10"));
        //End of first year = 110;
        //End of second year = 121;
        //End of third year = 133.1
        Assertions.assertEquals(new BigDecimal("133.10"), investment.getFinalCapital(3).setScale(2,RoundingMode.HALF_UP));
    }

    @Test
    public void testGetYield() {
        investment = new Investment(new BigDecimal("100.00"), new BigDecimal("0.10"));
        //End of first year = 110;
        //End of second year = 121;
        //End of third year = 133.1
        Assertions.assertEquals(new BigDecimal("33.10"), investment.getYield(3).setScale(2, RoundingMode.HALF_UP));
    }
}
