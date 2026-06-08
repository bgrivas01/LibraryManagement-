package com.example.LibraryManagement.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.LibraryManagement.Enums.BorrowStatus;
import com.example.LibraryManagement.Enums.MemberStatus;
import com.example.LibraryManagement.Repository.BorrowedRecordsRepository;
import com.example.LibraryManagement.entities.Book;
import com.example.LibraryManagement.entities.BorrowedRecords;
import com.example.LibraryManagement.entities.Member;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BorrowedRecordsService {

    private final BookService bookService;
    private final MemberService memberService;
    private final BorrowedRecordsRepository borrowedRecordsRepository;
    
    //need a way to list out the how Record
    
    public List<BorrowedRecords> getAllBorrowedRecords(){
        return borrowedRecordsRepository.findAll();
    }

    public BorrowedRecords getBorrowedRecordById(Long id){
        return borrowedRecordsRepository.findById(id).orElse(null);
    }


    public void borrowBook(Long bookId, Long memberid){
        Book book = bookService.getBookById(bookId).orElseThrow(() -> new RuntimeException("Book not found with id: " + bookId));
        Member member = memberService.getMemberById(memberid).orElseThrow(() -> new RuntimeException("Member not found with id: " + memberid));

        if (book.isAvailable() && member.getMemberStatus() == MemberStatus.ACTIVE){
            book.setAvailable(false);
            bookService.updateBook(bookId, book)
            ;
            BorrowedRecords borrowedRecord = new BorrowedRecords();
            borrowedRecord.setBook(book);
            borrowedRecord.setMember(member);
            borrowedRecord.setBorrowDate(LocalDate.now());
            borrowedRecord.setReturnDate(LocalDate.now().plusWeeks(2));
            borrowedRecord.setBorrowedStatus(BorrowStatus.BORROWED);

            borrowedRecordsRepository.save(borrowedRecord);
        } else {
            throw new RuntimeException("Book is not available or Member is not active");
        }
    }
        
    public void returnBook(Long borrowedRecordId){
        BorrowedRecords borrowedRecord = borrowedRecordsRepository.findById(borrowedRecordId).orElseThrow(() -> new RuntimeException("Borrowed record not found with id: " + borrowedRecordId));
        Book book = borrowedRecord.getBook();
        if (book.isAvailable() || borrowedRecord.getBorrowedStatus() != BorrowStatus.BORROWED) {
            throw new RuntimeException("Book is already available or record is not in borrowed status");
        }
        book.setAvailable(true);
        bookService.updateBook(book.getId(), book);

        borrowedRecord.setBorrowedStatus(BorrowStatus.RETURNED);
        borrowedRecord.setReturnDate(LocalDate.now());
        borrowedRecordsRepository.save(borrowedRecord);
    }


    //gives me the record of a book with a certain id
    public List<BorrowedRecords> getBorrowedRecordsByBookId(Long bookId){
        return borrowedRecordsRepository.findByBookId(bookId);
    }
    
    
}
