package com.employee.AdminDao;

import com.employee.AdminModel.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminDao extends JpaRepository<Admin,Integer> {
    Admin findByEmail(String email);
}
