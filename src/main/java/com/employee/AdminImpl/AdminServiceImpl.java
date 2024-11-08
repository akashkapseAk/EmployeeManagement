package com.employee.AdminImpl;

import com.employee.AdminDao.AdminDao;
import com.employee.AdminModel.Admin;
import com.employee.AdminService.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;


    @Override
    public Admin createPage(Admin admin) {


        Admin admin1 = this.adminDao.save(admin);
        return admin1;
    }
}
