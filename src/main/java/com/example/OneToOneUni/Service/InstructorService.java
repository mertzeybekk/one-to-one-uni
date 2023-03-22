package com.example.OneToOneUni.Service;

import com.example.OneToOneUni.Entity.Instructor;

import java.util.List;
import java.util.Optional;

public interface InstructorService {
    public  void addInstrutor(Instructor instructor);
    public Optional<Instructor> deleteInstructor(Long id);
    public void deleteAll();
    public Optional<List<Instructor>>getAll();
    public Optional<Instructor> getById(Long id);
    public Optional<Instructor> updateInstructor(Instructor instructor, Long id);
}
