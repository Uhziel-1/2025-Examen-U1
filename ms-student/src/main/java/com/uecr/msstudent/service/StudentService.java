package com.uecr.msstudent.service;

import com.uecr.msstudent.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    Student findById(int id);
    Student save(Student student);
    Student update(int id, Student student);
    void delete(int id);
}
