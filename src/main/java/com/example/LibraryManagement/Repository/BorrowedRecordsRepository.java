package com.example.LibraryManagement.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LibraryManagement.entities.BorrowedRecords;

@Repository
public interface BorrowedRecordsRepository extends JpaRepository<BorrowedRecords, Long> {
    
    public List<BorrowedRecords> findByBookId(Long bookId);
}