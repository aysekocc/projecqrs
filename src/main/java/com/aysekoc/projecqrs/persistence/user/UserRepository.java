package com.aysekoc.projecqrs.persistence.user;

import com.aysekoc.projecqrs.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
