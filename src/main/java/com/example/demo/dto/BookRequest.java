package com.example.demo.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest
{

    @NotBlank(message = "Title cannot be empty")
    private String title;


    @NotBlank(message = "Author name cannot be empty")
    private String author;

    @Positive(message = "price should be greater than 0")
    private double price;

    @NotBlank(message = "Category name cannot be empty")
    private String category;





}
