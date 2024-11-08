package com.employee.AdminModel;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Admin {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int adimId;


    private String fullName;

    private String email;

    private String password;

    private String confirmPassword;
}
