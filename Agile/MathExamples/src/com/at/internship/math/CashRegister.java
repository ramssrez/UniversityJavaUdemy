package com.at.internship.math;

import com.at.internship.input.Input;
import com.at.internship.input.InputAbortedException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class CashRegister {
    public static void main(String[] args) {
        Input input = new Input();
        BigDecimal total = BigDecimal.ZERO;
        int index= 1;
        System.out.println("Enter prices one per line: ");
        boolean keepReading = true;
        while (keepReading) {
            try {
                total = total.add(BigDecimal.valueOf(input.readDouble("Price " + index))).setScale(2, RoundingMode.HALF_UP);
                index++;
            }catch (InputAbortedException e){
                keepReading = false;
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Total amount: " + total);

        try {
            BigDecimal payment =BigDecimal.valueOf(input.readDouble("Enter payment")).setScale(2,RoundingMode.HALF_UP);
            BigDecimal change = payment.subtract(total);
            if (change.compareTo(BigDecimal.ZERO) < 0){
                System.out.println("You need to pay more" + change.abs());
            }else if (change.compareTo(BigDecimal.ZERO) == 0){
                System.out.println("You have no change");
            }
            else {
                System.out.printf("you receive a change $%s",change);
            }
        }catch (InputAbortedException e){
            System.out.println("Sale cancelled");
        }
    }
}
