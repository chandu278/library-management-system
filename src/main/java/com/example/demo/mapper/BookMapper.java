package com.example.demo.mapper;


import com.example.demo.dto.BookRequest;
import com.example.demo.dto.BookResponse;
import com.example.demo.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper
{
   public Book toEntity(BookRequest bookRequest)
   {
     Book book = new Book();
     book.setTitle(bookRequest.getTitle());
     book.setAuthor(bookRequest.getAuthor());
     book.setPrice(bookRequest.getPrice());
     book.setCategory(bookRequest.getCategory());
     return book;

   }

   public BookResponse toResponse(Book book)
   {
    BookResponse bookResponse = new BookResponse();
    bookResponse.setId(book.getId());
    bookResponse.setTitle(book.getTitle());
    bookResponse.setAuthor(book.getAuthor());
    bookResponse.setPrice(book.getPrice());
    bookResponse.setCategory(book.getCategory());
    return bookResponse;
   }
}
