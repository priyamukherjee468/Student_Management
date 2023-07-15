package com.example.StudentManagement.Service;

import com.example.StudentManagement.Model.Course;
import com.example.StudentManagement.Model.Student;
import com.example.StudentManagement.Repository.IBookRepo;
import com.example.StudentManagement.Repository.ICourseRepo;
import com.example.StudentManagement.Repository.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    ICourseRepo courseRepo;
    @Autowired
    IStudentRepo studentRepo;

    public String addCourse(Course course) {
        if(course!=null){
            List<Student> studentList=course.getStudentList();
            List<Student>studentList1=new ArrayList<>();
            for (Student student:studentList)
                 {
                Optional<Student> student1=studentRepo.findById(student.getStudentId());
                if (student1.isPresent()){
                    studentList1.add(student1.get());
                }else{
                    throw new IllegalStateException("Student id " +student.getStudentId() + " not present");
                }
            }
            course.setStudentList(studentList1);
            courseRepo.save(course);
            return "Course added successfully";
        }
        return "Course not added";
    }

    public List<Course> getAllCourse(Long courseId) {
        if(courseId==null){
            return courseRepo.findAll();
        }else{
            List<Course> courseList = new ArrayList<>();
            courseList.add(courseRepo.findById(courseId).get());
            return courseList;
        }
    }

    public String deleteCourseById(Long courseId) {
        Optional<Course> optionalcourse = courseRepo.findById(courseId);
        if(optionalcourse.isEmpty()){
            return "Course with id "+courseId + " is not present";
        }else{
            courseRepo.deleteById(courseId);
            return "Course with id "+courseId + " deleted successfully";
        }
    }

    public String updateCourse(Long courseId, Course course) {
        Optional<Course> optionalcourse = courseRepo.findById(courseId);

        if(optionalcourse.isEmpty()){
            return "Course with id "+courseId + " is not present";
        }else{
            List<Student> newStudentList = course.getStudentList();
            List<Student> listStudent = new ArrayList<>();

            for(Student student : newStudentList){
                Optional<Student> student1 = studentRepo.findById(student.getStudentId());
                if(student1.isPresent()){
                    listStudent.add(student1.get());

                }else{
                    throw new IllegalStateException("Student id " +student.getStudentId() + " not present");
                }
            }
            course.setStudentList(listStudent);
            course.setCourseId(courseId);
            courseRepo.save(course);
            return "Course with id "+courseId + " updated successfully";
        }
    }
    }

