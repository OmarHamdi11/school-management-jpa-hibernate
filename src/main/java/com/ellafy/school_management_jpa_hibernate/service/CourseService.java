package com.ellafy.school_management_jpa_hibernate.service;

import com.ellafy.school_management_jpa_hibernate.entity.Course;

import java.util.List;

public interface CourseService {

    public Course save(Course course);

    public List<Course> findAll();

    public Course findById(int theId);

    public void deleteById(int theId);

}
