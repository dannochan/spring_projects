package com.example.studentmgtsys.controller;

import com.example.studentmgtsys.entity.Student;
import com.example.studentmgtsys.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/students/new")
    public String createStudentForm(
            Model page
    ){
        Student student = new Student();
        page.addAttribute("student", student);
        return "create_student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.addStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable long id,
                                  Model page){
        page.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable long id,
                                @ModelAttribute("student") Student student,
                                Model model){
        // get student from db

        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setId(student.getId());
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        // save updated student object
        studentService.updateStudent(existingStudent);
        return "redirect:/students";
    }

    @GetMapping("/students/{id}")
    public String deleteStudent(
            @PathVariable long id
    ){
        studentService.deleteStudent(id);
        return "redirect:/students";
    }


}
