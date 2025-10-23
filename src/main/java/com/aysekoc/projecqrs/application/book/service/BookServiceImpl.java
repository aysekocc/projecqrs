package com.aysekoc.projecqrs.application.book.service;

import com.aysekoc.projecqrs.domain.entity.Book;
import com.aysekoc.projecqrs.persistence.book.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{
    private final BookRepository bookRepository;

    @Override
    public Book findById(UUID id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public UUID delete(UUID id) {
        bookRepository.deleteById(id);
        return id;
    }
}
