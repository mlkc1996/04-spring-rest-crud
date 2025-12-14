package com.example.demo.rest;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeRestController {


    @Autowired
    private EmployeeService employeeService;

    @GetMapping("")
    public List<Employee> getAll() {
        return employeeService.findAll();
    }

    @GetMapping("/")
    public List<Employee> getAll2() {
        return this.getAll();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable("id") int id) {
        return this.employeeService.findEmployeeById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") int id) {
        this.employeeService.removeEmployee(id);

    }

    @PatchMapping("/{id}")
    public void updateEmployee(@PathVariable("id") int id, @RequestBody HashMap<String, Object> content) {
        this.employeeService.updateEmployee(id, content);
    }


    @PostMapping("/")
    public void createEmployee(@RequestBody HashMap<String, Object> content) {
        this.employeeService.createEmployee(content);
    }
}
