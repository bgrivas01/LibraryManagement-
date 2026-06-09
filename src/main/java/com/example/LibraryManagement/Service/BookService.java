package com.example.LibraryManagement.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.LibraryManagement.Repository.BookRepository;
import com.example.LibraryManagement.entities.Book;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository; 

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id){ 
        return bookRepository.findById(id);
    }

    public Book addBook(Book book){
        return bookRepository.save(book);
    }

    public Book updateBook(Long Id, Book bookDetails){
        Optional<Book> optionalBook = bookRepository.findById(Id);
        if(optionalBook.isPresent()){
            Book bookToUpdate = optionalBook.get();
            bookToUpdate.setTitle(bookDetails.getTitle());
            bookToUpdate.setAuthor(bookDetails.getAuthor());
            bookToUpdate.setIsbn(bookDetails.getIsbn());
            bookToUpdate.setAvailable(bookDetails.isAvailable());
            return bookRepository.save(bookToUpdate);
        } else {
            throw new RuntimeException("Book not found with id: " + Id);
        }
    }

    public void deleteBook(Long id){
        if(bookRepository.existsById(id)){
            bookRepository.deleteById(id);
        } else {
            throw new RuntimeException("Book not found with id: " + id);
        }
    }
    
    
}
