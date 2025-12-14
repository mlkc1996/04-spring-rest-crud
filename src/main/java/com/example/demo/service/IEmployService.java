package com.example.demo.service;

import com.example.demo.entity.Employee;

import java.util.HashMap;
import java.util.List;

public interface IEmployService {
    List<Employee> findAll();

    Employee findEmployeeById(int id);

    Employee updateEmployee(int id, HashMap<String, Object> content);

    Employee createEmployee(HashMap<String, Object> content);

    void removeEmployee(int id);
}
