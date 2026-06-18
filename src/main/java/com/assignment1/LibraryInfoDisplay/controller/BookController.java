package com.assignment1.LibraryInfoDisplay.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment1.LibraryInfoDisplay.model.Book;
import com.assignment1.LibraryInfoDisplay.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;
    BookController(BookService bookService){
        this.bookService = bookService;
    }
    @GetMapping
    public List<Book> getAllBooksInfo(){
        return bookService.getAllBooks();
    }
    @GetMapping("/{id}")
    public Book getBookInfoById(@PathVariable int id){
        return bookService.getBookById(id);
    }
    @GetMapping("/author/{authorName}")
    public Book getBookInfoByAuthor(@PathVariable String authorName){
        return bookService.getBookByAuthor(authorName);
    }
    @GetMapping("/")
    public List<Book> getBookInfoByCategory(@RequestParam String category){
        return bookService.getBooksByCategory(category);
    }
}
