package com.at.internship.math;

import com.at.internship.Message;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
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
        //BigDecimal hypotenus =  mathUtils.hypotenuse(new BigDecimal("0.0"),new BigDecimal("4.0"));
        //BigDecimal hypotenus =  mathUtils.hypotenuse(new BigDecimal("3.0"),new BigDecimal("0"));
        //BigDecimal hypotenus =  mathUtils.hypotenuse(null,new BigDecimal("4.0"));
        //BigDecimal hypotenus =  mathUtils.hypotenuse(new BigDecimal("3.0"),null);
        Assertions.assertNotNull(hypotenus);
        Assertions.assertEquals(new BigDecimal("5.0"),hypotenus);
    }

    @Test
    public void testDistance(){
        //BigDecimal distance =  mathUtils.distance(new Point(0,0), new Point(3,4));
        BigDecimal distance =  mathUtils.distance(new Point(-1,0), new Point(2,4));
        //BigDecimal distance =  mathUtils.distance(new Point(0,-1), new Point(3,3));
        Assertions.assertNotNull(distance);
        Assertions.assertEquals(new BigDecimal("5.0"),distance);
    }

    @Test
    public void testPointOneThrow(){
        NullPointerException exception = Assertions.assertThrows(
                NullPointerException.class,
                ()->mathUtils.distance(null, new Point(3,4))
        );
        Assertions.assertEquals(Message.INFORMATION_POINT_ONE, exception.getMessage());
    }

    @Test
    public void testPointTwoThrow(){
        NullPointerException exception = Assertions.assertThrows(
                NullPointerException.class,
                ()->mathUtils.distance(new Point(3,4),null)
        );
        Assertions.assertEquals(Message.INFORMATION_POINT_TWO, exception.getMessage());
    }

    @Test
    public void testValidateHickOneThrow(){
        NullPointerException e = Assertions.assertThrows(
                NullPointerException.class,
                ()-> {
                    //mathUtils.hypotenuse(new BigDecimal("3.0"),new BigDecimal("4.0"));
                    mathUtils.hypotenuse(null,new BigDecimal("4.0"));
                }
        );
        Assertions.assertEquals(Message.INFORMATION_HICKS_ONE,e.getMessage());
    }

    @Test
    public void testValidateHickTwoThrow(){
        NullPointerException e = Assertions.assertThrows(
                NullPointerException.class,
                ()-> {
                    //mathUtils.hypotenuse(new BigDecimal("3.0"),new BigDecimal("4.0"));
                    mathUtils.hypotenuse(new BigDecimal("3.0"),null);
                }
        );
        Assertions.assertEquals(Message.INFORMATION_HICKS_TWO,e.getMessage());
    }

    @Test
    public void testValidateHickOneThrowZero(){
        IllegalArgumentException e = Assertions.assertThrows(
                IllegalArgumentException.class,
                ()-> {
                    mathUtils.hypotenuse(new BigDecimal("0.0"),new BigDecimal("4.0"));
                }
        );
        Assertions.assertEquals(Message.HICKS_ONE_CERO,e.getMessage());
    }

    @Test
    public void testValidateHickTwoThrowZero(){
        IllegalArgumentException e = Assertions.assertThrows(
                IllegalArgumentException.class,
                ()-> {
                    mathUtils.hypotenuse(new BigDecimal("3.0"),new BigDecimal("0"));
                }
        );
        Assertions.assertEquals(Message.HICKS_TWO_CERO,e.getMessage());
    }
}
