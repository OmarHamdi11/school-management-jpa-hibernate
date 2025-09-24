package com.ellafy.school_management_jpa_hibernate.service.instructorService;

import com.ellafy.school_management_jpa_hibernate.dao.InstructorRepository;
import com.ellafy.school_management_jpa_hibernate.entity.Instructor;
import com.ellafy.school_management_jpa_hibernate.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorServiceImpl implements InstructorService {

    private InstructorRepository instructorRepository;

    @Autowired
    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }


    @Override
    public Instructor save(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public List<Instructor> findAll() {
        return instructorRepository.findAll();
    }

    @Override
    public Instructor findById(int theId) {
        Optional<Instructor> optionalInstructor = instructorRepository.findById(theId);

        Instructor instructor = null;

        if (optionalInstructor.isPresent()){
            instructor = optionalInstructor.get();
        } else {
            throw new NotFoundException("Instructor with id - " + theId + " Not Found");
        }

        return instructor;
    }

    @Override
    public void deleteById(int theId) {
        Optional<Instructor> optionalInstructor = instructorRepository.findById(theId);

        if (optionalInstructor.isPresent()){
            instructorRepository.deleteById(theId);
        } else {
            throw new NotFoundException("Instructor with id - " + theId + " Not Found");
        }

    }
}
