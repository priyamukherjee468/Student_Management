package com.example.StudentManagement.Service;

import com.example.StudentManagement.Model.Laptop;
import com.example.StudentManagement.Model.Student;
import com.example.StudentManagement.Repository.IBookRepo;
import com.example.StudentManagement.Repository.ILaptopRepo;
import com.example.StudentManagement.Repository.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LaptopService {
    @Autowired
    ILaptopRepo laptopRepo;
    @Autowired
    IStudentRepo studentRepo;
    public String addLaptop(Laptop laptop) {
        if(laptop!=null){
            Student student=laptop.getStudent();
            Optional<Student> optionalStudent=studentRepo.findById(student.getStudentId());
            if(optionalStudent.isPresent()){
                laptopRepo.save(laptop);
                return "Laptop added successfully";

            }else{
                return "Enter valid details";
            }

        }

        return "Laptop not added successfully";

    }


    public List<Laptop> getAllLaptop(Long laptopId) {
        if(laptopId==null){
            return laptopRepo.findAll();
        }else{
            List<Laptop> laptopList = new ArrayList<>();
            laptopList.add(laptopRepo.findById(laptopId).get());
            return laptopList;
        }
    }

    public String deleteLaptopById(Long laptopId) {
        Optional<Laptop> optionalLaptop= laptopRepo.findById(laptopId);
        if(optionalLaptop.isEmpty()){
            return "Laptop with id "+laptopId + " is not present";
        }else{
            laptopRepo.deleteById(laptopId);
            return "Laptop with id "+laptopId + " deleted successfully";
        }
    }

    public String updateLaptop(Long laptopId, Laptop laptop) {
        Optional<Laptop> optionalLaptop = laptopRepo.findById(laptopId);
        Student student = laptop.getStudent();
        if(optionalLaptop.isEmpty()){
            return "Laptop with id "+laptopId + " is not present";
        }else{
            Optional<Student> student1 = studentRepo.findById(student.getStudentId());
            laptop.setStudent(student1.get());
            laptop.setLaptopId(laptopId);
            laptopRepo.save(laptop);
            return "Laptop with id "+laptopId + " updated successfully";
        }

    }
}
