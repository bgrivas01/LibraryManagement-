package com.example.LibraryManagement.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.LibraryManagement.Service.BookService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    
    
}
