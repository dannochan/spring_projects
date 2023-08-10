package com.example.studentmgtsys.service;

import com.example.studentmgtsys.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(long id);
    Student addStudent(Student student);
    Student updateStudent(Student student);
    void deleteStudent(long id);
}
