package com.SpringRest.demo.Service;

import com.SpringRest.demo.DAO.EmployeeDAO;
import com.SpringRest.demo.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO) {
        employeeDAO=theEmployeeDAO;

    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }
}
