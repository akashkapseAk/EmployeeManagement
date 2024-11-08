package com.employee.Pages;


import com.employee.Dto.EmployeesDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PageResponse {



    private List<EmployeesDto> content;


    private int pageNumber;

    private int pageSize;

    private long totalElements;

    private int totalPages;

    private  boolean lastPage;


}
