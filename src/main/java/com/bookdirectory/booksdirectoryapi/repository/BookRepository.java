package com.bookdirectory.booksdirectoryapi.repository;

import com.bookdirectory.booksdirectoryapi.models.entities.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
