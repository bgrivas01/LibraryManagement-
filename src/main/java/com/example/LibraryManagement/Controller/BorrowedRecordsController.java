package com.example.LibraryManagement.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.LibraryManagement.Service.BorrowedRecordsService;
import com.example.LibraryManagement.dto.BorrowRequest;
import com.example.LibraryManagement.entities.BorrowedRecords;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/borrowed-records")
@RequiredArgsConstructor
public class BorrowedRecordsController {

    private final BorrowedRecordsService borrowedRecordsService;

    @GetMapping
    public List<BorrowedRecords> getBorrowedRecords() {
        return borrowedRecordsService.getAllBorrowedRecords();
    }

    @GetMapping("/{id}")
    public BorrowedRecords getBorrowedRecordById(@PathVariable Long id) {
        return borrowedRecordsService.getBorrowedRecordById(id);
    }

    @PostMapping("/borrow")
    public void borrowBook(@RequestBody BorrowRequest request) {
        borrowedRecordsService.borrowBook(request.getBookId(), request.getMemberId());
    }
    
    @PutMapping("/return/{id}")
    public void returnBook(@PathVariable Long id) {
        borrowedRecordsService.returnBook(id);
    }

    @GetMapping("/book/{bookId}")
    public List<BorrowedRecords> getBorrowedRecordsByBookId(@PathVariable Long bookId) {
        return borrowedRecordsService.getBorrowedRecordsByBookId(bookId);
    }
}
