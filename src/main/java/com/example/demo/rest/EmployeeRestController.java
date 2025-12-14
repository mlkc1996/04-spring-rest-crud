package com.example.demo.rest;

import com.example.demo.entity.Employee;
import com.example.demo.service.IEmployService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeRestController {


    @Autowired
    private IEmployService employeeService;

    @GetMapping("")
    public List<Employee> getAll() {
        return employeeService.findAll();
    }


    @GetMapping("/{id}")
    public Employee getById(@PathVariable("id") int id) {
        return this.employeeService.findEmployeeById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") int id) {
        this.employeeService.removeEmployee(id);
    }

    @PatchMapping("/{id}")
    public Employee updateEmployee(@PathVariable("id") int id, @RequestBody HashMap<String, Object> content) {
        return this.employeeService.updateEmployee(id, content);
    }


    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee createEmployee(@RequestBody HashMap<String, Object> content) {
        return this.employeeService.createEmployee(content);
    }
}
