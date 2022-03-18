package com.at.internship.math;

import com.at.internship.input.AdvancedInput;

import java.awt.*;

public class Distance {
    public static void main(String[] args) {
        double distance = 0;
        AdvancedInput input = new AdvancedInput();
        Point point1 = input.readPoint("Point1: ");
        Point point2 = input.readPoint("Point 2");
        distance = Math.sqrt(Math.pow((point2.x-point1.x),2)+Math.pow((point2.y-point1.y),2));
        //Otra opcion
        double h1 = point2.y-point1.y;
        double h2 = point2.x-point1.x;
        distance = Math.hypot(h1,h2);
        System.out.printf(String.valueOf(point1.distance(point2)));
        System.out.printf(String.valueOf(point2.distance(point1)));



        System.out.printf("The distance is %s%n",distance);
    }
}
