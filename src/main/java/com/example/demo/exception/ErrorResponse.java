package com.example.demo.exception;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Data

@JsonPropertyOrder({"timestamp","status","error","message","path"})
public class ErrorResponse
{
    private LocalDateTime timestamp;
    private int status;
   private String message;
   private String path;
   private String error;




}
