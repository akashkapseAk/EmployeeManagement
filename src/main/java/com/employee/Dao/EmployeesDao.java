package com.employee.Dao;

import com.employee.Model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesDao extends JpaRepository<Employees,Integer> {
}
