package com.example.demo.dao;

import com.example.demo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    Employee create(Employee employee);

    List<Employee> findAll();

    Employee findById(int id);

    void update(Employee employee);

    void delete(int id);
}
