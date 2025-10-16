package com.aysekoc.projecqrs.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name="books")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @UuidGenerator
    @Id
    @Column(name="id")
    private UUID id;

    @Column(name="name")
    private String name;
}
