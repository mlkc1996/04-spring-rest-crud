package com.example.demo.dao;

import com.example.demo.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.List;

public interface EmployeeDAO {

    Employee create(Employee employee);

    List<Employee> findAll();

    Employee findById(int id);

    void update(Employee employee);

    int delete(int id);
}
