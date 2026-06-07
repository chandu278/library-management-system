package com.example.demo.repository;

import com.example.demo.dto.BookResponse;
import com.example.demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>
{
List<Book> findByAuthor(String author);
List<Book> findByCategory(String category);




}
