package com.example.OneToOneUni.Controller;

import com.example.OneToOneUni.Entity.Instructor;
import com.example.OneToOneUni.Service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/instructor")
public class InstructorController {
    @Autowired
    private InstructorService  instructorService;
    @PostMapping("/addInstructor")
    public void addInstructor(@RequestBody Instructor instructor){
        instructorService.addInstrutor(instructor);
    }
    @GetMapping("/getAll")
    public Optional<List<Instructor>> getAll(){
       return instructorService.getAll();
    }
    @GetMapping("/getById/{ınstructorId}")
    public Optional<Instructor> getAll(@PathVariable Long ınstructorId){
        return instructorService.getById(ınstructorId);
    }
    @DeleteMapping("/getDeleteAll")
    public void deleteAll(){
        instructorService.deleteAll();
    }
    @DeleteMapping("/getDeleteById/{deleteId}")
    public void deleteById(@PathVariable Long deleteId){
        instructorService.deleteInstructor(deleteId);
    }
    @PutMapping("updateInstructor/{id}")
    public Optional<Instructor> updateById(@RequestBody Instructor instructor,@PathVariable Long id) {
        return  instructorService.updateInstructor(instructor,id);
    }
}
