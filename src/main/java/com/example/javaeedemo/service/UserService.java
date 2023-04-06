package com.example.javaeedemo.service;

import com.example.javaeedemo.model.Physician;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    public List<Physician> getPhysicians(Statement stmt) throws SQLException {

        List<Physician> physicianList = new ArrayList<>();
        ResultSet rs = stmt.executeQuery("SELECT EmployeeID, Name, Position, SSN FROM physician WHERE name='Nguyen Hiep'");

        while(rs.next()){
            // Lay du lieu boi su dung ten cot
            Long id  = rs.getLong("EmployeeID");
            String name = rs.getString("Name");
            String pos = rs.getString("Position");
            int ssn = rs.getInt("SSN");

            Physician physician = new Physician(name, pos, ssn, id);
            physicianList.add(physician);
        }
        rs.close();
        return physicianList;
    }
}
