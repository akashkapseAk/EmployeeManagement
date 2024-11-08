package com.employee.Dto;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeesDto {



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
