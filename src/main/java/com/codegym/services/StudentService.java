package com.codegym.services;

import com.codegym.models.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> findAllStudent();
    Optional<Student> findByStudentId(Long id);
    Student saveStudent(Student student);
    void removeStudent(Long id);
    List<Student> findAllByStudentName(String studentName);
}
