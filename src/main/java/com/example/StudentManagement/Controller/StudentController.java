package com.example.StudentManagement.Controller;

import com.example.StudentManagement.Model.Student;
import com.example.StudentManagement.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("students")
    public String addStudent(@RequestBody Student student){

        return studentService.addStudent(student);
    }

    @GetMapping("students/{studentId}")
    public List<Student> getAllStudent(@PathVariable Long studentId){
        return studentService.getAllStudent(studentId);
    }

    @DeleteMapping("/{studentId}")
    public String deleteStudentById(@PathVariable Long studentId){
        return studentService.deleteStudentById(studentId);
    }

    @PutMapping("/{studentId}")
    public String updateStudent(@PathVariable Long studentId , @RequestBody Student student){
        return studentService.updateStudent(studentId , student);
    }
}
