package com.SpringRest.demo.DAO;

import com.SpringRest.demo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager theEntitymanager) {
        entityManager = theEntitymanager;
    }

    @Override
    public List<Employee> findAll() {

        TypedQuery<Employee> typedQuery = entityManager.createQuery("from Employee", Employee.class);
        List<Employee> employees = typedQuery.getResultList();
        return employees;

    }

    @Override
    public Employee findByid(int id) {
        Employee employee = entityManager.find(Employee.class,id);
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        Employee dbemployee=entityManager.merge(employee);
        return dbemployee;
    }

    @Override
    public void deleteById(int id) {
        Employee theepm=entityManager.find(Employee.class,id);
       entityManager.remove(theepm);
    }

}
