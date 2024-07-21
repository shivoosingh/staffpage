package com.example.staffmanagement;


import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StaffDataUtil {
    private static final String FILE_NAME = "staff_data.csv";

    public static void saveStaffData(List<Staff> staffList) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(FILE_NAME))) {
            // Write header
            writer.writeNext(new String[] { "StaffID", "Username", "Password", "FirstName", "LastName", "Email", "PhoneNo" });

            // Write staff data
            for (Staff staff : staffList) {
                writer.writeNext(new String[] {
                        staff.getStaffID(),
                        staff.getUsername(),
                        staff.getPassword(),
                        staff.getFirstName(),
                        staff.getLastName(),
                        staff.getEmail(),
                        staff.getPhoneNo()
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Staff> loadStaffData() {
        List<Staff> staffList = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(FILE_NAME))) {
            String[] line;
            // Skip header
            reader.readNext();

            // Read staff data
            while ((line = reader.readNext()) != null) {
                staffList.add(new Staff(line[0], line[1], line[2], line[3], line[4], line[5], line[6]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return staffList;
    }
}
