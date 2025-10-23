package com.aysekoc.projecqrs.application.author.rules;

import com.aysekoc.projecqrs.domain.entity.Author;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthorBusinessRules {
    public void authorCanNotBeNull(Author author) {
        if (author == null) {
            throw new RuntimeException("Author can not be null");
        }
    }
}
