package com.bookdirectory.booksdirectoryapi.controllers;

import com.bookdirectory.booksdirectoryapi.models.entities.Book;
import com.bookdirectory.booksdirectoryapi.services.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping
    public List<Book> listAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> showBook(@PathVariable Long id){
        Optional<Book> optBook = service.findById(id);

        if (optBook.isPresent()){
            return ResponseEntity.ok(optBook.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity<?> createBook(@RequestBody Book book){
        Book newBook = service.save(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(newBook);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editBook(@RequestBody Book book, @PathVariable Long id){
        Optional<Book> optBook = service.findById(id);

        if (optBook.isPresent()){
            Book updatedBook = optBook.orElseThrow();

            // actualiza campos del libro seleccionado
            updatedBook.setName(book.getName());
            updatedBook.setAuthor(book.getAuthor());
            updatedBook.setYear(book.getYear());
            updatedBook.setGenre(book.getGenre());

            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(updatedBook));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeBook(@PathVariable Long id){
        Optional<Book> optBook = service.findById(id);

        if (optBook.isPresent()){
            service.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
