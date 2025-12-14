package com.example.demo.dao;

import com.example.demo.entity.Employee;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    EntityManager entityManager;


    @Override
    @Transactional
    public Employee create(Employee employee) {
        this.entityManager.persist(employee);
        return employee;
    }

    @Override
    public List<Employee> findAll() {
        var query = this.entityManager.createQuery("from Employee", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee findById(int id) {
        var query = this.entityManager.createQuery("from Employee where id=:id", Employee.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void update(Employee employee) {
        this.entityManager.merge(employee);
    }

    @Override
    @Transactional
    public void delete(int id) {
        var query = this.entityManager.createQuery("delete from Employee where id=:id", Employee.class);
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
