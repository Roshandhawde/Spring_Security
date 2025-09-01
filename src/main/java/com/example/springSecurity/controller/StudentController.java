package com.example.springSecurity.controller;

import com.example.springSecurity.entity.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class StudentController {

    private List<Student> students = new ArrayList<>(List.of(
            new Student(1,"Roshan", 20),
            new Student(2,"Rakesh", 30 )
    ));
    @GetMapping("/students")
    public List<Student> getStudent() {
return students;
    }

    @GetMapping("/csrf-token")
public CsrfToken CsrfToken (HttpServletRequest request){
return (CsrfToken) request.getAttribute("_csrf");
    }
    @PostMapping("/students")
    public List<Student> getStudent(@RequestBody Student student) {
        students.add(student);
        return students;
    }
}
