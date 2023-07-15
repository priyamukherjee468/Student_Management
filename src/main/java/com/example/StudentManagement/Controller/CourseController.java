package com.example.StudentManagement.Controller;

import com.example.StudentManagement.Model.Course;
import com.example.StudentManagement.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    CourseService courseService;


    @PostMapping("addCourse")
    public String addCourse(@RequestBody Course course){
        return courseService.addCourse(course);
    }

    @GetMapping("courses/courseId")
    public List<Course> getAllCourse(@PathVariable Long courseId){
        return courseService.getAllCourse(courseId);
    }

    @DeleteMapping("/{courseId}")
    public String deleteCourseById(@PathVariable Long courseId){
        return courseService.deleteCourseById(courseId);
    }

    @PutMapping("/{courseId}")
    public String updateCourse(@PathVariable Long courseId , @RequestBody Course course){
        return courseService.updateCourse(courseId , course);
    }
}
