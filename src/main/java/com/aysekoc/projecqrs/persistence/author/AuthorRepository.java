package com.aysekoc.projecqrs.persistence.author;

import com.aysekoc.projecqrs.domain.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorRepository extends JpaRepository<Author, UUID> {
}
