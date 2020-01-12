package com.codegym.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Clazz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long classId;
    private String className;
    @OneToMany(targetEntity = Student.class)
    List<Student> studentList;
    public Clazz() {
    }

    public Clazz(String className, List<Student> studentList){
        this.className = className;
        this.studentList = studentList;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}