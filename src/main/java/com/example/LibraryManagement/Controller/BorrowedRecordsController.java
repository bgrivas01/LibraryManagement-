package com.example.LibraryManagement.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<BorrowedRecords>> getBorrowedRecords() {
        return ResponseEntity.ok(borrowedRecordsService.getAllBorrowedRecords());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BorrowedRecords> getBorrowedRecordById(@PathVariable Long id) {
        return borrowedRecordsService.getBorrowedRecordById(id)
                .map(borrowedRecord -> ResponseEntity.ok(borrowedRecord))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/borrow")
    public ResponseEntity<BorrowedRecords> borrowBook(@RequestBody BorrowRequest request) {
        BorrowedRecords saved = borrowedRecordsService.borrowBook(request.getBookId(), request.getMemberId());
        return ResponseEntity.status(201).body(saved);
    }
    
    @PutMapping("/return/{id}")
    public ResponseEntity<BorrowedRecords> returnBook(@PathVariable Long id) {
        return ResponseEntity.ok(borrowedRecordsService.returnBook(id));
    }

    @GetMapping("/book/{bookId}")
    public ResponseEntity<List<BorrowedRecords>> getBorrowedRecordsByBookId(@PathVariable Long bookId) {
        return ResponseEntity.ok(borrowedRecordsService.getBorrowedRecordsByBookId(bookId));
    }
}
