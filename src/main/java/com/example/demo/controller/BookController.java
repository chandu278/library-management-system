package com.example.demo.controller;


import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class BookController
{
    @Autowired
    private BookService bookService;

    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@Valid @RequestBody Book book)
    {

       return bookService.addBook(book);
    }
    @GetMapping("/books")

    public List<Book> getBooks()
    {

        return bookService.getBooks();
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<?> getBookById( @PathVariable Long id)

    {
        return new ResponseEntity<>(bookService.getBookById(id),HttpStatus.OK);
    }



    @DeleteMapping("/books/{id}")
    public  ResponseEntity<?>  deleteBookById(@PathVariable Long id)
    {
     bookService.deleteBookById(id);
    return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<?>  updateBookById(@Valid @RequestBody Book book, @PathVariable Long id)
    {
        return new ResponseEntity<>(bookService.updateBookById(book,id),HttpStatus.ACCEPTED);
    }



}
