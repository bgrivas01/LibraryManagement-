package com.example.LibraryManagement.Service;

import org.springframework.stereotype.Service;

import com.example.LibraryManagement.Repository.BorrowedRecordsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BorrowedRecordsService {

    private final BorrowedRecordsRepository borrowedRecordsRepository;
    

    
    
}
