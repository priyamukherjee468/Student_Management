package com.example.StudentManagement.Controller;

import com.example.StudentManagement.Model.Book;
import com.example.StudentManagement.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookService bookService;
    @PostMapping("saveBooks")
    public String addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @GetMapping("getBook/{bookId}")
    public List<Book> getAllBooks(@PathVariable Long bookId){
        return bookService.getAllBooks(bookId);
    }
    @DeleteMapping("deleteBooks/{bookId}")
    public String deleteBooks(@PathVariable Long bookId){
        return bookService.deleteBooks(bookId);
    }
    @PutMapping("/{bookId}")
    public String updateBook(@PathVariable Long bookId , @RequestBody Book book){
        return bookService.updateBook(bookId , book);
    }

}
