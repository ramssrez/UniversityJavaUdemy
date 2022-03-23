package com.at.intership.schedule.specification;

import com.at.intership.schedule.repositorio.AppointmenteRespository;
import com.at.intership.schedule.repositorio.ContactRepository;

import java.util.HashMap;
import java.util.Map;

public class SingletonRepository {
    /*
    private static Map<String, Object>  singletontMap;
    public static  final String KEY_CONTACT_REPOSITORY = "contactRespository";
    public static  final String KEY_APPOINTMENT_REPOSITORy = "appointmenteRespository";
    static {
        singletontMap = new HashMap<>();
        singletontMap.put(KEY_CONTACT_REPOSITORY, new ContactRepository());
        singletontMap.put(KEY_APPOINTMENT_REPOSITORy, new AppointmenteRespository());
    }


     */
    private SingletonRepository(){}
}
