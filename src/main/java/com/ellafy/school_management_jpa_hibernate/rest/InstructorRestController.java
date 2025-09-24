package com.ellafy.school_management_jpa_hibernate.rest;


import com.ellafy.school_management_jpa_hibernate.entity.Instructor;
import com.ellafy.school_management_jpa_hibernate.response.ApiResponse;
import com.ellafy.school_management_jpa_hibernate.service.InstructorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InstructorRestController {

    private final InstructorService instructorService;
    private final ObjectMapper objectMapper;

    @Autowired
    public InstructorRestController(InstructorService instructorService, ObjectMapper objectMapper) {
        this.instructorService = instructorService;
        this.objectMapper = objectMapper;
    }

    @PostMapping("/instructors")
    public ResponseEntity<ApiResponse<Instructor>> addInstructor(@RequestBody Instructor instructor){
        instructor.setId(0);

        Instructor instructor1 =  instructorService.save(instructor);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "Success",
                        System.currentTimeMillis(),
                        instructor1
                )
        );
    }

    @GetMapping("/instructors")
    public ResponseEntity<ApiResponse<List<Instructor>>> findAll(){
        List<Instructor> instructors = instructorService.findAll();

        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.FOUND.value(),
                        "Success",
                        System.currentTimeMillis(),
                        instructors
                )
        );
    }

    @GetMapping("/instructors/{instructorId}")
    public ResponseEntity<ApiResponse<Instructor>> getInstructor(@PathVariable int instructorId){
        Instructor instructor = instructorService.findById(instructorId);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.FOUND.value(),
                        "Success",
                        System.currentTimeMillis(),
                        instructor
                )
        );
    }

    @DeleteMapping("/instructors/{instructorId}")
    public ResponseEntity<ApiResponse<String>> deleteInstructor(@PathVariable int instructorId){

        instructorService.deleteById(instructorId);

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
