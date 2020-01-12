package com.codegym.controllers;

import com.codegym.models.Student;
import com.codegym.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping("/api/student/")
    public ResponseEntity<List<Student>> getStudentList(){
        List<Student> studentList = studentService.findAllStudent();
        if(studentList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }

    @PostMapping("/api/student/")
    public ResponseEntity<Student> createStudent(@RequestBody Student student, UriComponentsBuilder ucBuilder){
        studentService.saveStudent(student);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/student/{id}").buildAndExpand(student.getStudentId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
}