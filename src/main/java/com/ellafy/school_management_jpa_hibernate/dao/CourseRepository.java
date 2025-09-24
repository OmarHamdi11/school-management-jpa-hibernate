package com.ellafy.school_management_jpa_hibernate.dao;

import com.ellafy.school_management_jpa_hibernate.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course , Integer> {

}
