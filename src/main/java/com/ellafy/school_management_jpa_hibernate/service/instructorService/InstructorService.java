package com.ellafy.school_management_jpa_hibernate.service.instructorService;

import com.ellafy.school_management_jpa_hibernate.entity.Instructor;

import java.util.List;

public interface InstructorService {

    public Instructor save(Instructor instructor);

    public List<Instructor> findAll();

    public Instructor findById(int theId);

    public void deleteById(int theId);
}
