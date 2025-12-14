package com.example.demo.rest;

import com.example.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    List<Student> students = new ArrayList<Student>();

    @PostConstruct
    public void loadData() {
        students.add(new Student("a", "b"));
        students.add(new Student("a", "b"));
        students.add(new Student("a", "b"));
        students.add(new Student("a", "b"));
    }


    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable("studentId") int studentId) {
        if (this.students.size() <= studentId || studentId < 0) {
            throw new StudentNotFoundException(String.format("Student id not found - %d", studentId));
        }
        return this.getStudents().get(studentId);
    }


}
