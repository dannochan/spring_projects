package com.example.studentmgtsys.service.impl;

import com.example.studentmgtsys.entity.Student;
import com.example.studentmgtsys.repository.StudentRepository;
import com.example.studentmgtsys.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    // declare the repository
    private StudentRepository studentRepository;
    // constructor with repository as arg
    public StudentServiceImpl(StudentRepository studentRepository){
        super();
        this.studentRepository=studentRepository;
    }

    // get all existing students in DB
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(long id) {
        return studentRepository.findById(id).get(); // findById return an optinal object, use get() to obtain student
    }

    // add new Student to DB
    @Override
    public Student addStudent(Student student) {

        return studentRepository.save(student);
    }
    // update student information

    @Override
    public Student updateStudent(long id) {
        return null;
    }
    // delete student

    @Override
    public void deleteStudent(long id) {

    }
}
