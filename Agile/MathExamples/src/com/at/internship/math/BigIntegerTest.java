package com.at.internship.math;

import java.math.BigInteger;

public class BigIntegerTest {
    public static void main(String[] args) {
        System.out.println("Max integre: " + Integer.MAX_VALUE);
        System.out.println("Max Long: " + Long.MAX_VALUE);
        System.out.println("Long overflow: " + (Long.MAX_VALUE +1));
        System.out.println("Big integer " + BigInteger.valueOf(Long.MAX_VALUE).add(BigInteger.ONE));
    }
}