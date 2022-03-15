package com.at.intership.schedule.specification;

public class SpacificatinUtils {
    private SpacificatinUtils() {
    }

    public static boolean like(String source, String substr){
        if(source == null)
            return false;
        if(substr == null)
            return true;
        return source.toLowerCase().contains(substr.toLowerCase());
    }
}
