package com.at.internship.math;

import com.at.internship.Message;

import java.awt.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class MathUtils {

    /**
     * Calculates the hypotenuse of a right triangle based on provided hicks
     * @param hick1 a hick
     * @param hick2 another hick
     * @return Hypotenuse value
     */
    public BigDecimal hypotenuse(BigDecimal hick1, BigDecimal hick2) {
        if (hick1 == null)
            throw new NullPointerException(Message.INFORMATION_HICKS_ONE);
        if (hick2 == null)
            throw new NullPointerException(Message.INFORMATION_HICKS_TWO);
        if (hick1.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException(Message.HICKS_ONE_CERO);
        if (hick2.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException(Message.HICKS_TWO_CERO);
        // Values cannot be null
        // Values should be greater than 0;
        return BigDecimal.valueOf(Math.hypot(hick1.doubleValue(), hick2.doubleValue())).setScale(1, RoundingMode.HALF_UP);
    }

    /**
     * Calculates the distance between the points "a" and "b"
     * @param a initial point
     * @param b ending point
     * @return The distance between points "a" and "b"
     */
    public BigDecimal distance(Point a, Point b) {
        if(a == null) throw new NullPointerException(Message.INFORMATION_POINT_ONE);
        if(b == null) throw new NullPointerException(Message.INFORMATION_POINT_TWO);

        // Points cannot be null
        // Coordinates x and y can be positive or negative
        return BigDecimal.valueOf(a.distance(b)).setScale(1,RoundingMode.HALF_UP);
    }

}
