package com.employee.Controller;


import com.employee.Dto.EmployeesDto;
import com.employee.Pages.PageConstant;
import com.employee.Pages.PageResponse;
import com.employee.Service.EmployeesService;
import com.employee.exception.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@CrossOrigin("*")
public class EmpController {



    @Autowired
    private EmployeesService employeesService;

    private static final Logger log= LoggerFactory.getLogger(EmpController.class);



    @PostMapping("/")
    public ResponseEntity<EmployeesDto> createEmp(@RequestBody EmployeesDto employeesDto)
    {
        try {


            log.info("enter the create enployees from empController class{}"+employeesDto);
            EmployeesDto employee = this.employeesService.createEmployee(employeesDto);
            log.info("exit  the create enployees from empController class{}"+employeesDto);

            return new ResponseEntity<>(employee, HttpStatus.CREATED);

        }catch (Exception ex)
        {
            log.error("error occurred in create employees from EmpController Class{}"+ex.getMessage(),employeesDto);
        }
        log.info("error check the create enployees from empController class{}"+employeesDto);

        EmployeesDto employee = this.employeesService.createEmployee(employeesDto);

        log.info("exit error check the create enployees from empController class{}"+employeesDto);

        return new ResponseEntity<>(employee,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeesDto>> getAllEMp()
    {
        try {
            log.info("enter the getAll enployees from empController class{}");

            List<EmployeesDto> allEmp = this.employeesService.getAllEmp();
            log.info("exit the getAll enployees from empController class{}");

            return new ResponseEntity<>(allEmp,HttpStatus.OK);
        }catch (Exception ex)
        {

            log.error("error occurred in getAll employees from EmpController Class{}"+ex.getMessage());
        }
        log.info("error check the getAll enployees from empController class{}");

        List<EmployeesDto> allEmp = this.employeesService.getAllEmp();

        log.info("exit error check the getAll enployees from empController class{}");

        return new ResponseEntity<>(allEmp,HttpStatus.NO_CONTENT);
    }

    @GetMapping("/s/{empId}")
    public ResponseEntity<EmployeesDto> getSingleEmp(@PathVariable("empId") int empId)
    {
        try {
            log.info("enter the get Single enployees from empController class{}"+empId);


            EmployeesDto singleEmp = this.employeesService.getSingleEmp(empId);
            log.info("exit the get Single enployees from empController class{}"+empId);
            return new ResponseEntity<>(singleEmp,HttpStatus.OK);

        }catch (Exception ex)
        {
            log.error("error occurred in get Single employees from EmpController Class{}"+ex.getMessage());

        }

        log.info("error check the get Single enployees from empController class{}"+empId);
        EmployeesDto singleEmp = this.employeesService.getSingleEmp(empId);
        log.info("exit error check the get Single enployees from empController class{}"+empId);
        return new ResponseEntity<>(singleEmp,HttpStatus.NOT_FOUND);
    }


    @PutMapping("/up/{empId}")
    public ResponseEntity<EmployeesDto> updateEmp(@RequestBody EmployeesDto employeesDto,@PathVariable Integer empId)
    {
        try {

            log.info("enter the update enployees from empController class{}"+empId);

            EmployeesDto updateEmp = this.employeesService.updateEmp(employeesDto, empId);
            log.info("exit the update enployees from empController class{}"+empId);
            return new ResponseEntity<>(updateEmp,HttpStatus.OK);

        }catch (Exception ex)
        {
            log.error("error occurred in update employees from EmpController Class{}"+ex.getMessage());

        }

        log.info("error check the update enployees from empController class{}"+empId);

        EmployeesDto updateEmp = this.employeesService.updateEmp(employeesDto, empId);
        log.info("exit error check the update enployees from empController class{}"+empId);
        return new ResponseEntity<>(updateEmp,HttpStatus.NOT_MODIFIED);
    }


    @DeleteMapping("/d/{empId}")
    public ResponseEntity<ApiResponse> deleteEmp(@PathVariable Integer empId)
    {
        try {

            this.employeesService.deleteEmp(empId);

            return new ResponseEntity<>(new ApiResponse("Employees delete Successfully",true),HttpStatus.OK);

        }catch (Exception ex)
        {
            log.error("error occurred in delete employees from EmpController Class{}"+ex.getMessage());

        }

        return new ResponseEntity<>(new ApiResponse("error in delete Employees",true),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/all/pages")
    public ResponseEntity<PageResponse> getAllPages(
            @RequestParam(name = "pageNumber",defaultValue = PageConstant.PAGE_NUMBER,required = false) int pageNumber,
            @RequestParam(name = "pageSize",defaultValue = PageConstant.PAGE_SIZE,required = false) int pageSize,
            @RequestParam(name = "sortBy",defaultValue = PageConstant.SORT_BY,required = false) String sortBy,
            @RequestParam(name = "sortDir",defaultValue = PageConstant.SORT_DIR,required = false) String sortDir
    )
    {
        try {

            log.info("enter the getAll pages from empController class{}"+pageSize);
            PageResponse allPages = this.employeesService.getAllPages(pageNumber, pageSize, sortBy, sortDir);
            log.info("exit the getAll pages from empController class{}"+pageSize);
            return new ResponseEntity<>(allPages,HttpStatus.OK);
        }catch (Exception ex)
        {
            log.error("error occurred in getAllpages  from EmpController Class{}"+ex.getMessage());

        }
        log.info("error check the getAll pages from empController class{}"+pageSize);
        PageResponse allPages = this.employeesService.getAllPages(pageNumber, pageSize, sortBy, sortDir);
        log.info("exit error check the getAll pages from empController class{}"+pageSize);
        return new ResponseEntity<>(allPages,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
