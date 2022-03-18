package com.at.internship.math;

import com.at.internship.input.Input;
import com.at.internship.input.InputAbortedException;

public class Hypotenuse {
    public static void main(String[] args) {
        try {
            Input input = new Input();
            double hick1 = input.readDouble("Hich 1", false);
            double hick2 = input.readDouble("Hick 2", false);
            double hyotenuse = Math.sqrt(Math.pow(hick1,2) + Math.pow(hick2,2));
            System.out.println("The hypotenuse: " + hyotenuse);
        }catch (InputAbortedException e){
            System.out.println(e.getMessage());
        }
    }
}
