package com.employee.Service;

import com.employee.Dto.EmployeesDto;
import com.employee.Pages.PageResponse;

import java.util.List;

public interface EmployeesService {



    public EmployeesDto createEmployee(EmployeesDto employeesDto);


    public List<EmployeesDto> getAllEmp();


    public EmployeesDto getSingleEmp(int empId);

    public EmployeesDto updateEmp(EmployeesDto employeesDto,int empId);


    public void deleteEmp(int empId);


    public PageResponse getAllPages(int pageNumber,int pageSize,String sortBy, String sortDir);
}
