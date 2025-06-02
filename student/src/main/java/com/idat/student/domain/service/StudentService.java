package com.idat.student.domain.service;

import com.idat.student.domain.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    Student findById(String uid);
    Student save(Student student);
    Student update(String uid,Student student);
    void delete(String uid);
}
