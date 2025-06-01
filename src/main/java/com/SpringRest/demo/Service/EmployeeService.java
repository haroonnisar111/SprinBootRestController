package com.SpringRest.demo.Service;

import com.SpringRest.demo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findByid(int id);
    Employee save(Employee employee);
    void deleteById(int id);
}
