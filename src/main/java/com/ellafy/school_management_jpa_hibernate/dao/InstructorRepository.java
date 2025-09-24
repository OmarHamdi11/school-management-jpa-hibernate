package com.ellafy.school_management_jpa_hibernate.dao;

import com.ellafy.school_management_jpa_hibernate.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor , Integer> {

}
