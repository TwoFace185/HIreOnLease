package com.Bonami.HireOnlease.controller;

import com.Bonami.HireOnlease.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    List<Student> list = new ArrayList<>();

    @GetMapping("/token")
    public CsrfToken getSsrf(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @GetMapping("/get")
    public List<Student> getSTudent(){
         list.add(new Student(1,"shivam","56"));
         return list;
    }

    @PostMapping("/add")
    public String addStudent(){
        Student student1 = new Student(2,"sivam","2");
        list.add(student1);
        return "Student added succesfully";
    }

}
