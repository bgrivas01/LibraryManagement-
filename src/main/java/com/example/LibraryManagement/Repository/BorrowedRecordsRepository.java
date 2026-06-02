package com.example.LibraryManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.LibraryManagement.entities.BorrowedRecords;

public interface BorrowedRecordsRepository extends JpaRepository<BorrowedRecords, Long> {
    
}
