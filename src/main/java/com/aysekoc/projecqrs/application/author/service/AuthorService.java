package com.aysekoc.projecqrs.application.author.service;

import com.aysekoc.projecqrs.domain.entity.Author;

import java.util.List;
import java.util.UUID;

public interface AuthorService {
    Author findById(UUID id);
    List<Author> findAll();
    Author save(Author author);
    UUID delete(UUID id);

}
