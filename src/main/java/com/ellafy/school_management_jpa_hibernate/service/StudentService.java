package com.ellafy.school_management_jpa_hibernate.service;

import com.ellafy.school_management_jpa_hibernate.entity.Student;

import java.util.List;

public interface StudentService {
    public Student save(Student student);

    public List<Student> findAll();

    public Student findById(int theId);

    public void deleteById(int theId);
}
