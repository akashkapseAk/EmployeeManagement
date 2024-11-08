package com.employee.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employees {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int empId;

    private String fullName;
    private String email;

    private String contact;

    private String gender;

    private String department;

    private String designation;

    private long salary;

    private String joiningDate;





}
