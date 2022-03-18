package com.at.internship.math;

import com.at.internship.input.Input;
import com.at.internship.input.InputAbortedException;

import javax.swing.plaf.IconUIResource;

public class CashRegister {
    public static void main(String[] args) {
        Input input = new Input();
        double total = 0;
        int index= 1;
        System.out.println("Enter prices one per line: ");
        try {
            while (true){
                total += input.readDouble("Price " + index);
                index++;
            }
        }catch (InputAbortedException e){
            //System.out.println(e.getMessage(e.getMessage());
        }
        System.out.println("Total amount: " + total);

        try {
            double payment = input.readDouble("Enter payment");
            double change = payment - total;
            if (change < 0){
                System.out.println("You need to pay more" + Math.abs(change));
            }else {
                System.out.printf("you receive a change $%s",change);
            }
        }catch (InputAbortedException e){
            System.out.println("Sale cancelled");
        }
    }
}
