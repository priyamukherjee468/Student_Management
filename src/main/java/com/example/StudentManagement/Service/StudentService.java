package com.example.StudentManagement.Service;

import com.example.StudentManagement.Model.Student;
import com.example.StudentManagement.Repository.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    IStudentRepo studentRepo;

    public String addStudent(Student student) {
        if(student!=null){
            studentRepo.save(student);
            return "Student added successfully";
        }
        return "Student not added!";


    }

    public List<Student> getAllStudent(Long studentId) {
        if(studentId==null){
            return studentRepo.findAll();
        }else{
            List<Student> studentList = new ArrayList<>();
            studentList.add(studentRepo.findById(studentId).get());
            return studentList;
        }
    }

    public String deleteStudentById(Long studentId) {
        Optional<Student> optionalStudent = studentRepo.findById(studentId);
        if(optionalStudent.isEmpty()){
            return "Student with id "+studentId + " is not present";
        }else{
            studentRepo.deleteById(studentId);
            return "Student with id "+studentId + " deleted successfully";
        }
    }

    public String updateStudent(Long studentId, Student student) {
        Optional<Student> optionalStudent = studentRepo.findById(studentId);
        if(optionalStudent.isEmpty()){
            return "Student with id "+studentId + " is not present";
        }else{
            student.setStudentId(studentId);
            studentRepo.save(student);
            return "Student with id "+studentId + " updated successfully";
        }
    }
}
