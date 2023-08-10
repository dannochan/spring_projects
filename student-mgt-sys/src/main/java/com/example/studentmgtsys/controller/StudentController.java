package com.example.studentmgtsys.controller;

import com.example.studentmgtsys.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {
    private StudentService studentService;

    public StudentController( StudentService studentService){
        super();
        this.studentService=studentService;
    }

    // a method receive a student list and display
    @GetMapping("/students")
    public String studentList(
            Model page
    ){
    page.addAttribute("students", studentService.getAllStudents());
        return "students";
    }
}
