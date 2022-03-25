package com.at.internship.schedule.serialization.csv;

import com.at.internship.schedule.Constants;
import com.at.internship.schedule.domain.Appointment;
import com.at.internship.schedule.domain.Contact;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ApoitmentSerializer {
    public static final String FILE_NAME = "Appoitment.csv";

    private String getFileName(){
        return Constants.SERIALIZATION_PATH + FILE_NAME;
    }
    public void serialize (List<Appointment> list) throws IOException {
        String fileName = getFileName();
        CsvSerializer serializer = new CsvSerializer();
        serializer.setHeaders(new CsvSerializer.Row("ID","Contact ID","Local Date","Subject","Contact"));
        for (Appointment appointment : list){
            serializer.addRow(
                    new CsvSerializer.Row(
                            appointment.getId(),
                            appointment.getContactId(),
                            appointment.getTime(),
                            appointment.getSubject(),
                            appointment.getContact()
                    )
            );
        }
        try (PrintWriter writer = new PrintWriter(fileName, StandardCharsets.UTF_8)) {
            for (String line : serializer){
                writer.println(line);
            }
        }catch (IOException e){
            throw e;
        }
    }
    /*
        private Integer id;
    private Integer contactId;
    private LocalDateTime time;
    private String subject;
    private Contact contact;
     */

    public List<Appointment> deserialize(){
        String fileName = getFileName();
        List<Appointment> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fileName))){
            if (scanner.hasNextLine()){scanner.nextLine(); }
            while (scanner.hasNextLine()){
                CsvSerializer.Row row = CsvSerializer.Row.deserialize(scanner.nextLine());
                Appointment appointment = new Appointment();
                appointment.setId(Integer.parseInt(row.getValueAt(0)));
                appointment.setContactId(Integer.parseInt(row.getValueAt(1)));
                appointment.setTime(LocalDateTime.parse(row.getValueAt(2)));
                appointment.setSubject(row.getValueAt(3));
                appointment.setSubject(row.getValueAt(4));
                list.add(appointment);
            }
        }catch (Exception e){
            System.err.printf("Table reading failed due to error %s: %s%n",e.getClass().getName(),e.getMessage());
            System.err.println("Changes may not be soved if the error persists");
        }
        return list;
    }
}
