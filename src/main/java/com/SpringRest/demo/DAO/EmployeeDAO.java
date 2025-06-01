package com.SpringRest.demo.DAO;

import com.SpringRest.demo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findByid(int id);
     Employee save(Employee employee);
      void deleteById(int id);

}
