package com.ellafy.school_management_jpa_hibernate.rest;


import com.ellafy.school_management_jpa_hibernate.entity.Course;
import com.ellafy.school_management_jpa_hibernate.response.ApiResponse;
import com.ellafy.school_management_jpa_hibernate.exception.NotFoundException;
import com.ellafy.school_management_jpa_hibernate.service.CourseService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseRestController {

    private CourseService courseService;
    private ObjectMapper objectMapper;

    @Autowired
    public CourseRestController(CourseService courseService, ObjectMapper objectMapper) {
        this.courseService = courseService;
        this.objectMapper = objectMapper;
    }

    @PostMapping("/courses")
    public ResponseEntity<ApiResponse<Course>> addCourse(@RequestBody Course course){
        course.setId(0);

        Course course1 =  courseService.save(course);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "Success",
                        System.currentTimeMillis(),
                        course
                )
        );
    }

    @GetMapping("/courses")
    public ResponseEntity<ApiResponse<List<Course>>> findAll(){
        List<Course> courses = courseService.findAll();

        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.FOUND.value(),
                        "Success",
                        System.currentTimeMillis(),
                        courses
                )
        );
    }

    @GetMapping("/courses/{courseId}")
    public ResponseEntity<ApiResponse<Course>> getCourse(@PathVariable int courseId){
        Course course = courseService.findById(courseId);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.FOUND.value(),
                        "Success",
                        System.currentTimeMillis(),
                        course
                )
        );
    }

    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<ApiResponse<String>> deleteCourse(@PathVariable int courseId){
        Course course = courseService.findById(courseId);

        courseService.deleteById(courseId);

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
