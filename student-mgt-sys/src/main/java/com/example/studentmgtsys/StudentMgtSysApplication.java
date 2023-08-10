package com.example.studentmgtsys;

import com.example.studentmgtsys.entity.Student;
import com.example.studentmgtsys.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentMgtSysApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentMgtSysApplication.class, args);
    }

//    @Autowired
//    private StudentRepository studentRepository;
//    @Override
//    public void run(String... args) throws Exception {
//        Student student1 = new Student("John", "Doe", "johndoe@gmail.com");
//        Student student2= new Student("Jane", "Doe", "janedoe@gmail.com");
//        Student student3 = new Student("Jack", "Smith", "jacksmith@gmail.com");
//
//        studentRepository.save(student1);
//        studentRepository.save(student2);
//        studentRepository.save(student3);
//    }
}
