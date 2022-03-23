package com.at.internship.math;

import com.at.internship.input.Input;
import com.at.internship.input.InputAbortedException;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CompoundUnterest {
    public static void main(String[] args) {
        try {
            Input input = new Input();
            BigDecimal c = input.readBigDecimal("Provide initial capital",false);
            BigDecimal i = input.readBigDecimal("Provide interes rate: ", false);
            int t = input.readInt("Provide time in years: ",false);
            BigDecimal finalCapital = c.multiply(i.add(BigDecimal.ONE).pow(t)).setScale(2, RoundingMode.HALF_UP);
            System.out.printf("After %s years your capital will increse to $ %s%n",t, finalCapital);
        } catch (InputAbortedException e) {
            System.out.println("Ingreso de datos cancelado");
            //e.printStackTrace();
        }
    }

}
