package com.at.internship.input;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Input {
    private static final String STR_ABORT_INPUT = "--";

    private Scanner scanner;

    public Input() {
        scanner = new Scanner(System.in);
    }

    public String readLineUnhandled(String prompt) {
        System.out.print(prompt + " >_");
        return scanner.nextLine();
    }

    public double readDouble(String prompt) throws InputAbortedException {
        return readDouble(prompt, true);
    }

    public double readDouble(String prompt, boolean allowsNegative) throws InputAbortedException {
        while(true) {
            try {
                String sval = readLineUnhandled(prompt);
                if(STR_ABORT_INPUT.equals(sval)) throw new InputAbortedException();
                double val = Double.parseDouble(sval);
                if(!allowsNegative) validateNoNegative(val);
                return val;
            } catch (NumberFormatException e) {
                System.err.printf("Enter a valid number or \"%s\" to cancel%n%n", STR_ABORT_INPUT);
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public int readInt(String prompt) throws InputAbortedException {
        return readInt(prompt, true);
    }

    public int readInt(String prompt, boolean allowsNegative) throws InputAbortedException {
        while(true) {
            try {
                String sval = readLineUnhandled(prompt);
                if(STR_ABORT_INPUT.equals(sval)) throw new InputAbortedException();
                int val = Integer.parseInt(sval);
                if(!allowsNegative) validateNoNegative(val);
                return val;
            } catch (NumberFormatException e) {
                System.err.printf("Enter an integer number or \"%s\" to cancel%n%n", STR_ABORT_INPUT);
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public BigDecimal readBigDecimal(String prompt) throws InputAbortedException {
        return readBigDecimal(prompt, true);
    }

    public BigDecimal readBigDecimal(String prompt, boolean allowsNegative) throws InputAbortedException {
        while(true) {
            try {
                String sval = readLineUnhandled(prompt);
                if(STR_ABORT_INPUT.equals(sval)) throw new InputAbortedException();
                BigDecimal val = BigDecimal.valueOf(Double.parseDouble(sval)).setScale(2,RoundingMode.HALF_UP);
                if(!allowsNegative) validateNoNegative(val);
                return val;
            } catch (NumberFormatException e) {
                System.err.printf("Enter a valide number or \"%s\" to cancel%n%n", STR_ABORT_INPUT);
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public void validateNoNegative(BigDecimal bd){
        System.out.println("Entra al no negative decimal");
        if(bd.compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("Enter positive values");
    }

    protected void validateNoNegative(double value) {
        if(value < 0)
            throw new IllegalArgumentException("Enter positive values");
    }

}
