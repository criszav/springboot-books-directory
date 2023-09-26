package com.bookdirectory.booksdirectoryapi.services;

import com.bookdirectory.booksdirectoryapi.models.entities.Book;
import com.bookdirectory.booksdirectoryapi.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Book> findAll() {
        return (List<Book>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Book> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Book save(Book book) {
        return repository.save(book);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
