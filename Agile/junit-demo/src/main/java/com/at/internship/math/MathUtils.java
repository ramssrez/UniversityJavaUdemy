package com.at.internship.math;

import java.awt.*;
import java.math.BigDecimal;

public class MathUtils {

    /**
     * Calculates the hypotenuse of a right triangle based on provided hicks
     * @param hick1 a hick
     * @param hick2 another hick
     * @return Hypotenuse value
     */
    public BigDecimal hypotenuse(BigDecimal hick1, BigDecimal hick2) {
        // Values cannot be null
        // Values should be greater than 0;
        return BigDecimal.valueOf(Math.hypot(hick1.doubleValue(), hick2.doubleValue()));
    }

    /**
     * Calculates the distance between the points "a" and "b"
     * @param a initial point
     * @param b ending point
     * @return The distance between points "a" and "b"
     */
    public BigDecimal distance(Point a, Point b) {
        // Points cannot be null
        // Coordinates x and y can be positive or negative
        return BigDecimal.valueOf(a.distance(b));
    }

}
