package com.example.LibraryManagement.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.LibraryManagement.Service.BorrowedRecordsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/borrowed-records")
@RequiredArgsConstructor
public class BorrowedRecordsController {

    private final BorrowedRecordsService borrowedRecordsService;
    
}
