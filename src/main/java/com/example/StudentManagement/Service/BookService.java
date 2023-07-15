package com.example.StudentManagement.Service;

import com.example.StudentManagement.Model.Address;
import com.example.StudentManagement.Model.Book;
import com.example.StudentManagement.Model.Student;
import com.example.StudentManagement.Repository.IBookRepo;
import com.example.StudentManagement.Repository.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    IBookRepo bookRepo;
    @Autowired
    IStudentRepo studentRepo;
    public String addBook(Book book) {
        if(book!=null){
            Long studentId = book.getStudent().getStudentId();
            Optional<Student> student = studentRepo.findById(studentId);
            if(student.isPresent()){
                book.setStudent(student.get());
                bookRepo.save(book);
                return "Book added successfully";
            }

        }
        return "Book not added.";

    }

    public List<Book> getAllBooks(Long bookId) {
        if (bookId!=null){
            List<Book>bookList=new ArrayList<>();
            bookList.add(bookRepo.findById(bookId).get());
            return bookList;
        }
        return bookRepo.findAll();
    }

    public String deleteBooks(Long bookId) {
        Optional<Book> optionalbook = bookRepo.findById(bookId);
        if(optionalbook.isEmpty()){
            return "Book with id "+bookId + " is not present";
        }else{
            bookRepo.deleteById(bookId);
            return "Book with id "+bookId + " deleted successfully";
        }
    }

    public String updateBook(Long bookId, Book book)
    {
        Optional<Book>optionalBook=bookRepo.findById(bookId);
        Student student=book.getStudent();
        if(optionalBook.isEmpty()){
            return "bookId is invalid!";
        }else{
            Optional<Student>student1=studentRepo.findById(student.getStudentId());
            book.setStudent(student1.get());
            bookRepo.save(book);
            return "book with id"+bookId+"updated successfully.";
        }

    }
}
