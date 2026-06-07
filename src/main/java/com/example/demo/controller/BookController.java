package com.example.demo.controller;


import com.example.demo.dto.BookRequest;
import com.example.demo.dto.BookResponse;
import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.BookService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
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
    @ResponseStatus(HttpStatus.CREATED)
    public BookResponse addBook(@Valid @RequestBody BookRequest bookRequest)
    {
      return bookService.addBook(bookRequest);
    }


    @GetMapping("/books")
    @ResponseStatus(HttpStatus.OK)
    public List<BookResponse> getBooks()
    {

        return bookService.getBooks();
    }

    @GetMapping("/books/{id}")
    @ResponseStatus(HttpStatus.OK)
    public  BookResponse getBookById( @PathVariable Long id)

    {

        return bookService.getBookById(id);
    }



    @DeleteMapping("/books/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public  void  deleteBookById(@PathVariable Long id)
    {
     bookService.deleteBookById(id);

    }

    @PutMapping("/books/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookResponse updateBookById(@Valid @RequestBody BookRequest bookRequest, @PathVariable Long id)
    {
        return bookService.updateBookById(bookRequest,id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/books/author")
    public List<BookResponse> findByAuthor( @RequestParam  String author)
    {
        return bookService.findByAuthor(author);
    }

    @GetMapping("/books/category")
    @ResponseStatus(HttpStatus.OK)
    public List<BookResponse> findByCategory( @RequestParam  String category)
    {
        return bookService.findByCategory(category);
    }

    @GetMapping("/books/sort/title")
    @ResponseStatus(HttpStatus.OK)
    public List<BookResponse> sortByTitle()
    {
        return bookService. sortByTitle();
    }

    @GetMapping("/books/sort/price")
    @ResponseStatus(HttpStatus.OK)
    public  List<BookResponse> sortByPrice()
    {
        return bookService.sortByPrice();
    }

}
