package com.ellafy.school_management_jpa_hibernate.service;

import com.ellafy.school_management_jpa_hibernate.dao.StudentRepository;
import com.ellafy.school_management_jpa_hibernate.entity.Student;
import com.ellafy.school_management_jpa_hibernate.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(int theId) {
        Optional<Student> optionalStudent = studentRepository.findById(theId);

        Student student = null;

        if (optionalStudent.isPresent()){
            student = optionalStudent.get();
        } else {
            throw new NotFoundException("Student with id - " + theId + " Not Found");
        }

        return student;
    }

    @Override
    public void deleteById(int theId) {
        Optional<Student> optionalStudent = studentRepository.findById(theId);

        if (optionalStudent.isPresent()){
            studentRepository.deleteById(theId);
        } else {
            throw new NotFoundException("Student with id - " + theId + " Not Found");
        }
    }
}
