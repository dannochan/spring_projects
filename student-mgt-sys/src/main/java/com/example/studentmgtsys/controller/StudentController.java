package com.example.studentmgtsys.controller;

import com.example.studentmgtsys.entity.Student;
import com.example.studentmgtsys.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/student/new")
    public String createStudentForm(
            Model page
    ){
        Student student = new Student();
        page.addAttribute("student", student);
        return "creat_student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.addStudent(student);
        return "redirect:/students";
    }
}
