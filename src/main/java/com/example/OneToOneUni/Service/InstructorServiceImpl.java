package com.example.OneToOneUni.Service;

import com.example.OneToOneUni.Entity.Instructor;
import com.example.OneToOneUni.Exception.CustomNotChange;
import com.example.OneToOneUni.Exception.CustomNotFoundException;
import com.example.OneToOneUni.Exception.CustomerNotNullException;
import com.example.OneToOneUni.Repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorServiceImpl implements InstructorService{
    @Autowired(required = false)
    private  InstructorRepository instructorRepository;

    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    public void addInstrutor(Instructor instructor) {
         if(instructor==null){
             throw new CustomerNotNullException("Boş bir değer geldi eklenemez");
         }
         instructorRepository.save(instructor);
    }

    @Override
    public Optional<Instructor> deleteInstructor(Long id) {
      Optional<Instructor> instructor=  instructorRepository.findById(id);
      if(!instructor.isPresent()){
          throw new CustomNotFoundException("Böyle bir kayır yok");
      }
      instructorRepository.deleteById(id);
      return instructor;
    }

    @Override
    public void deleteAll() {

         instructorRepository.deleteAll();
    }

    @Override
    public Optional<List<Instructor>> getAll() {
        return Optional.of(Optional.of(instructorRepository.findAll()).orElse(null));
    }

    @Override
    public Optional<Instructor> getById(Long id) {
        Optional<Instructor> instructor=instructorRepository.findById(id);
        if(!instructor.isPresent()) throw new CustomNotFoundException("böyle bir kayıt yok");
        return instructor;
    }

    @Override
    public Optional<Instructor> updateInstructor(Instructor instructor, Long id) {
        Optional<Instructor> optionalInstructor=instructorRepository.findById(id);
        if(optionalInstructor.isPresent()){
            optionalInstructor.get().setEmail(instructor.getEmail());
            optionalInstructor.get().setFirstName(instructor.getFirstName());
            optionalInstructor.get().setLastName(instructor.getLastName());
            optionalInstructor.get().setInstructorDetail(instructor.getInstructorDetail());
            instructorRepository.save(optionalInstructor.get());
        }
        throw new CustomNotChange("Not change value");

    }
}
