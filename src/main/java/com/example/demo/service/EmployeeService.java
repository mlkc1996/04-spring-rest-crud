package com.example.demo.service;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.entity.Employee;
import com.example.demo.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    public List<Employee> findAll() {
        return this.employeeDAO.findAll();
    }

    public Employee findEmployeeById(int id) {
        return this.employeeDAO.findById(id);
    }

    public Employee updateEmployee(int id, HashMap<String, Object> content) {
        var employee = this.findEmployeeById(id);


        if (employee != null) {

            if (content.isEmpty()) {
                return employee;
            }

            if (content.containsKey("email")) {
                employee.setEmail((String) content.get("email"));
            }

            if (content.containsKey("firstName")) {
                employee.setFirstName((String) content.get("firstName"));
            }

            if (content.containsKey("lastName")) {
                employee.setLastName((String) content.get("lastName"));
            }

            this.employeeDAO.update(employee);
            return employee;
        }


        throw new NotFoundException("Employee id not found - " + id);
    }

    public Employee createEmployee(HashMap<String, Object> content) {

        var employee = new Employee((String) content.get("firstName"), (String) content.get("lastName"), (String) content.get("email"));

        this.employeeDAO.create(employee);
        return employee;
    }

    public void removeEmployee(int id) {
        this.employeeDAO.delete(id);
    }
}
