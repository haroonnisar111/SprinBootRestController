package com.SpringRest.demo.rest;

import com.SpringRest.demo.DAO.EmployeeDAO;
import com.SpringRest.demo.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class EmployeeRestController {

private EmployeeDAO employeeDAO;

    @GetMapping("/employee")
    public List<Employee> findAll(){
        return employeeDAO.findAll();
    }

}
