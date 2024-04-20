package com.library.Library.Controllers;

import com.library.Library.Models.Book;
import com.library.Library.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    //Endpoint per te marr listen e gjith librave
    @GetMapping
    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    //Endpoint per te marr librin nga ID
    @GetMapping("/{ID}")
    public  ResponseEntity<Book> getBookById(@PathVariable int ID){
        Optional<Book> optimalBook = bookRepository.findById(ID);
        return optimalBook.map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    // Endpoint to create a new book
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book Book) {
        Book savedBook = bookRepository.save(Book);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }

    // Endpoint to update an existing book
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int ID, @RequestBody Book bookDetails) {
        Optional<Book> optionalBook = bookRepository.findById(ID);
        if (optionalBook.isPresent()) {
            Book existingBook = optionalBook.get();
            existingBook.setTitle(bookDetails.getTitle());
            existingBook.setAuthor(bookDetails.getAuthor());
            // Set other fields as needed
            Book updatedBook = bookRepository.save(existingBook);
            return ResponseEntity.ok(updatedBook);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint to delete a book
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable int ID) {
        Optional<Book> optionalBook = bookRepository.findById(ID);
        if (optionalBook.isPresent()) {
            bookRepository.deleteById(ID);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }







}
