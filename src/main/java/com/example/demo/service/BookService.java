package com.example.demo.service;


import com.example.demo.exception.BookNotFoundException;
import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService
{
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getBooks()
    {

        return bookRepository.findAll();
    }

    public ResponseEntity<?> getBookById(Long id)
    {
       return new ResponseEntity<>( bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book Not Found with id:"+id)),HttpStatus.OK);

    }

    public void deleteBook()
    {

        bookRepository.deleteAll();
    }
    public void  deleteBookById(Long id)
    {
        Optional<Book> existingBook=bookRepository.findById(id);
        if(existingBook.isPresent()) bookRepository.deleteById(id);

        else throw new BookNotFoundException("Book Not Found with id:"+id);



    }

    public ResponseEntity<?> updateBookById(Book book, Long id) {
      Book exisitingbook=bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book Not Found with id: " + id));
      exisitingbook.setTitle(book.getTitle());
      exisitingbook.setAuthor(book.getAuthor());
      exisitingbook.setPrice(book.getPrice());
      exisitingbook.setCategory(book.getCategory());
     return new ResponseEntity<>(bookRepository.save(exisitingbook),HttpStatus.ACCEPTED);

    }

    public ResponseEntity<Book> addBook(Book book)
    {
        return new  ResponseEntity<>(bookRepository.save(book), HttpStatus.CREATED);
    }
}
