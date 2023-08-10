package com.example.studentmgtsys.service;

import com.example.studentmgtsys.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student addStudent(Student student);
    Student updateStudent(long id);
    void deleteStudent(long id);
}
