package com.at.internship.math;

import com.at.internship.finance.Investment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class MathUtilsTest {
    MathUtils mathUtils;

    @BeforeEach
    public void beforeEach(){
        mathUtils = new MathUtils();
        System.out.println("Before Each");
    }

    @Test
    public void testHypotenuse(){
        BigDecimal hypotenus =  mathUtils.hypotenuse(new BigDecimal("3.0"),new BigDecimal("4.0"));
        //BigDecimal hypotenus =  mathUtils.hypotenuse(null,new BigDecimal("4.0"));
        Assertions.assertNotNull(hypotenus);
        Assertions.assertEquals(new BigDecimal("5.0"),hypotenus);
    }

    @Test
    public void testValidateHypotenuseNull(){
        NullPointerException e = Assertions.assertThrows(
                NullPointerException.class,
                ()-> mathUtils.hypotenuse(new BigDecimal("3.0"),new BigDecimal("4.0"))
        );
        Assertions.assertEquals("Los valores ingresados son nulos",e.getMessage());
    }
}
