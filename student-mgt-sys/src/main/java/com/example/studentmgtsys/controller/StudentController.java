package com.example.studentmgtsys.controller;

import com.example.studentmgtsys.service.impl.StudentServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {
    private StudentServiceImpl studentService;

    public StudentController( StudentServiceImpl studentService){
        super();
        this.studentService=studentService;
    }

    // a method receive a student list and display
    @GetMapping("/")
    public String studentList(
            Model page
    ){
    page.addAttribute("students", studentService.getAllStudents());

        return "students";
    }
}
