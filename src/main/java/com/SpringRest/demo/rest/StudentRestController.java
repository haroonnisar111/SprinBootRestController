package com.SpringRest.demo.rest;

import com.SpringRest.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    @PostConstruct
    public void loadData() {
        students = new ArrayList<>();
        students.add(new Student("ulfat", "auyoob", "ulfat@gmail.com"));
        students.add(new Student("harooon", "nisar", "haroon@gmail.com"));
        students.add(new Student("sharaf", "rashud", "sharaf@gmail.com"));

    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;

    }

    @GetMapping("/student/{studentId}")
    public Student getStudentbyId(@PathVariable int studentId) {
        if (studentId >= students.size() || studentId < 0) {
            throw new StudentNotFoundException("Student id not Found- " + studentId);
        }

        return students.get(studentId);

    }





}
