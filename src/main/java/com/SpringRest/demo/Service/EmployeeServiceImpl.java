package com.SpringRest.demo.Service;

import com.SpringRest.demo.DAO.EmployeeDAO;
import com.SpringRest.demo.DAO.EmployeeRepository;
import com.SpringRest.demo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

//    for using normal DAO We Can Use The Below Code as Dao are Already defined
 // to get all the methods in build we use    Sprng Jpa Repository
//
//    private EmployeeDAO employeeDAO;

//    public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO) {
//        employeeDAO = theEmployeeDAO;
//
//    }
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findByid(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        Employee theEmployee = null;
        if (result.isPresent()) {
            theEmployee = result.get();
        } else {
            throw new RuntimeException("did not found by id" + id);
        }
        return theEmployee;
    }@Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
