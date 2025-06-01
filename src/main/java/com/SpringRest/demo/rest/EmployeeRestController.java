package com.SpringRest.demo.rest;

import com.SpringRest.demo.Service.EmployeeService;
import com.SpringRest.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId) {
        Employee employee = employeeService.findByid(employeeId);
        if (employee == null) {
            throw new RuntimeException("Employee id not Found: " + employeeId);
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        employee.setId(0);
        Employee dbemployee = employeeService.save(employee);
        return dbemployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        Employee dbemployee = employeeService.save(employee);
        return dbemployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteById(@PathVariable int employeeId) {
        Employee employee = employeeService.findByid(employeeId);
        if(employee==null){
            throw new RuntimeException("Employee id not Found: " + employeeId);
        }
        employeeService.deleteById(employeeId);
        return "Deleted employee id  --" +employeeId;
    }

}
