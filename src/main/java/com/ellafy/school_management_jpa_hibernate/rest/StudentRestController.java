package com.ellafy.school_management_jpa_hibernate.rest;


import com.ellafy.school_management_jpa_hibernate.entity.Instructor;
import com.ellafy.school_management_jpa_hibernate.entity.Student;
import com.ellafy.school_management_jpa_hibernate.response.ApiResponse;
import com.ellafy.school_management_jpa_hibernate.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private StudentService studentService;
    private ObjectMapper objectMapper;

    @Autowired
    public StudentRestController(StudentService studentService, ObjectMapper objectMapper) {
        this.studentService = studentService;
        this.objectMapper = objectMapper;
    }

    @PostMapping("/students")
    public ResponseEntity<ApiResponse<Student>> addStudent(@RequestBody Student student){
        student.setId(0);

        Student student1 =  studentService.save(student);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "Success",
                        System.currentTimeMillis(),
                        student1
                )
        );
    }

    @GetMapping("/students")
    public ResponseEntity<ApiResponse<List<Student>>> findAll(){
        List<Student> students = studentService.findAll();

        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.FOUND.value(),
                        "Success",
                        System.currentTimeMillis(),
                        students
                )
        );
    }

    @GetMapping("/students/{studentId}")
    public ResponseEntity<ApiResponse<Student>> getStudent(@PathVariable int studentId){
        Student student = studentService.findById(studentId);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.FOUND.value(),
                        "Success",
                        System.currentTimeMillis(),
                        student
                )
        );
    }

    @DeleteMapping("/students/{studentId}")
    public ResponseEntity<ApiResponse<String>> deleteStudent(@PathVariable int studentId){

        studentService.deleteById(studentId);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "Success",
                        System.currentTimeMillis(),
                        null
                )
        );
    }
}
