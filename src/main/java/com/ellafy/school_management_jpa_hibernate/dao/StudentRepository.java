package com.ellafy.school_management_jpa_hibernate.dao;

import com.ellafy.school_management_jpa_hibernate.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student , Integer> {
    
}
