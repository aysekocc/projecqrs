package com.aysekoc.projecqrs.application.book.rules;

import com.aysekoc.projecqrs.domain.entity.Book;
import com.aysekoc.projecqrs.persistence.book.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class BookBusinessRules {
    private final BookRepository bookRepository;

    public void bookShouldExistWithGivenId(UUID id) {
        bookRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Book with id " + id + " does not exist"));
    }

    public void bookShouldNotBeNull(Book book) {
        if(book == null) {
            throw new RuntimeException("Book cannot be null");
        }
    }
}
