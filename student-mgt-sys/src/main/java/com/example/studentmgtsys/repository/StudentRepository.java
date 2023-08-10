package com.example.studentmgtsys.repository;

import com.example.studentmgtsys.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
