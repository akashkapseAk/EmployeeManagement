package com.employee.ServiceImpl;


import com.employee.Dao.EmployeesDao;
import com.employee.Dto.EmployeesDto;
import com.employee.Model.Employees;
import com.employee.Pages.PageResponse;
import com.employee.Service.EmployeesService;
import com.employee.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeesImpl implements EmployeesService {



    @Autowired
    private EmployeesDao employeesDao;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EmployeesDto createEmployee(EmployeesDto employeesDto) {


        Employees employees = this.modelMapper.map(employeesDto, Employees.class);

        Employees employees1 = this.employeesDao.save(employees);

        EmployeesDto employeesDto1 = this.modelMapper.map(employees1, EmployeesDto.class);
        return employeesDto1;
    }

    @Override
    public List<EmployeesDto> getAllEmp() {

        List<Employees> all = this.employeesDao.findAll();

        List<EmployeesDto> employeesDtos = all.stream().map(e -> this.modelMapper.map(e, EmployeesDto.class)).collect(Collectors.toList());
        return employeesDtos;
    }

    @Override
    public EmployeesDto getSingleEmp(int empId) {


        Employees employees = this.employeesDao.findById(empId).orElseThrow(() -> new ResourceNotFoundException("Employees", "empId", empId));

        EmployeesDto singleemp = this.modelMapper.map(employees, EmployeesDto.class);
        return singleemp;
    }

    @Override
    public EmployeesDto updateEmp(EmployeesDto employeesDto, int empId) {

        Employees employees = this.employeesDao.findById(empId).orElseThrow(() -> new ResourceNotFoundException("Employees", "empId", empId));

       employees.setFullName(employeesDto.getFullName());
        employees.setContact(employeesDto.getContact());
        employees.setEmail(employeesDto.getEmail());
        employees.setGender(employeesDto.getGender());

        employees.setDepartment(employeesDto.getDepartment());
        employees.setDesignation(employeesDto.getDesignation());
        employees.setSalary(employeesDto.getSalary());

        Employees employees1 = this.employeesDao.save(employees);

        EmployeesDto dtupdatedto = this.modelMapper.map(employees1, EmployeesDto.class);

        return dtupdatedto;
    }

    @Override
    public void deleteEmp(int empId) {


        Employees employees = this.employeesDao.findById(empId).orElseThrow(() -> new ResourceNotFoundException("Employees", "empId", empId));

        this.employeesDao.delete(employees);
    }

    @Override
    public PageResponse getAllPages(int pageNumber, int pageSize, String sortBy, String sortDir) {

        Sort sort=sortDir.equalsIgnoreCase("asc")?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();


        PageRequest of = PageRequest.of(pageNumber, pageSize, sort);


        Page<Employees> pagePost = this.employeesDao.findAll(of);

        List<Employees> employeesList = pagePost.getContent();

        List<EmployeesDto> employeesDtos = employeesList.stream().map(e -> this.modelMapper.map(e, EmployeesDto.class)).collect(Collectors.toList());


        PageResponse response=new PageResponse();

        response.setContent(employeesDtos);
        response.setPageNumber(pagePost.getNumber());
        response.setPageSize(pagePost.getSize());
        response.setTotalElements(pagePost.getTotalElements());
        response.setTotalPages(pagePost.getTotalPages());
        response.setLastPage(pagePost.isLast());


        return response;
    }
}
