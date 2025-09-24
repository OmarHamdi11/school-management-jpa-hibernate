package com.ellafy.school_management_jpa_hibernate.service;

import com.ellafy.school_management_jpa_hibernate.dao.CourseRepository;
import com.ellafy.school_management_jpa_hibernate.entity.Course;
import com.ellafy.school_management_jpa_hibernate.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService{

    private CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }


    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course findById(int theId) {
        Optional<Course> courseOptional = courseRepository.findById(theId);
        Course course = null;
        if (courseOptional.isPresent()){
            course = courseOptional.get();
        } else {
            throw new NotFoundException("Course with id - " + theId + " Not Found");
        }
        return course;
    }

    @Override
    public void deleteById(int theId) {
        courseRepository.deleteById(theId);
    }

}
