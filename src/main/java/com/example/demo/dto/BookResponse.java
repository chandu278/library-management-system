package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@JsonPropertyOrder({"id","title","author","category","price"})

public class BookResponse
{
    private long id;
    private String author;
    private String category;
    private String title;
    private double price;
}
