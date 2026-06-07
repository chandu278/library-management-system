package com.example.demo.service;


import com.example.demo.dto.BookRequest;
import com.example.demo.dto.BookResponse;
import com.example.demo.entity.Book;
import com.example.demo.exception.BookNotFoundException;
import com.example.demo.mapper.BookMapper;
import com.example.demo.repository.BookRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class BookService
{
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;


    public List<BookResponse> getBooks()
    {
        List<Book> books = bookRepository.findAll();
        return books.stream().map(b -> bookMapper.toResponse(b)).toList();
    }

    public BookResponse getBookById(Long id)
    {
       Optional<Book> book = bookRepository.findById(id);

       return bookMapper.toResponse(book.orElseThrow(() -> new BookNotFoundException("Book not found With Id: " + id)));

    }

    public void  deleteBookById(Long id)
    {
      Book exitsingBook=bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book not found With Id: " + id));
      bookRepository.delete(exitsingBook);
    }


    public BookResponse addBook(BookRequest bookRequest)
    {
      Book book=bookRepository.save(bookMapper.toEntity(bookRequest));
      return bookMapper.toResponse(book);
    }

    public BookResponse updateBookById(BookRequest bookRequest, Long id)
    {
    Book existingbook=bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book Not Found With Id:"+id));

    existingbook.setTitle(bookRequest.getTitle());
    existingbook.setAuthor(bookRequest.getAuthor());
    existingbook.setPrice(bookRequest.getPrice());
    existingbook.setCategory(bookRequest.getCategory());

    Book updatedBook=bookRepository.save(existingbook);

    return bookMapper.toResponse(updatedBook);
    }

    public List<BookResponse> findByAuthor(String author)
    {
        List<Book> books = bookRepository.findByAuthor(author);
        return books.stream().map(b -> bookMapper.toResponse(b)).toList();
    }

    public  List<BookResponse> findByCategory(String category)
    {
        List<Book> books=bookRepository.findByCategory(category);
        return books.stream().map(b -> bookMapper.toResponse(b)).toList();
    }

    public List<BookResponse> sortByTitle()
    {
        List<Book> books=bookRepository.findAll(Sort.by("title"));
        return books.stream().map(b -> bookMapper.toResponse(b)).toList();

    }

    public List<BookResponse>   sortByPrice()
    {
        List<Book> books=bookRepository.findAll(Sort.by("price"));
        return books.stream().map(b -> bookMapper.toResponse(b)).toList();
    }

}