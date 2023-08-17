package com.bookdirectory.booksdirectoryapi.services;

import com.bookdirectory.booksdirectoryapi.models.entities.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    // obtiene todos los libros
    List<Book> findAll();

    // obtiene un libro por id
    Optional<Book> findById(Long id);

    // guarda un libro
    Book save(Book book);

    // elimina un libro
    void deleteById(Long id);
}
