package com.aysekoc.projecqrs.persistence.student;

import com.aysekoc.projecqrs.domain.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {
}
