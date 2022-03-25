package com.at.internship.schedule.serialization.csv;

import com.at.internship.schedule.Constants;

public class ApoitmentSerializer {
    public static final String FILE_NAME = "Appoitment.csv";

    private String getFileName(){
        return Constants.SERIALIZATION_PATH + FILE_NAME;
    }
    
}
