package com.ilyaKovalenko.library.LibraryOnTheMargin.repository;

import com.ilyaKovalenko.library.LibraryOnTheMargin.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByUsername(String username);

}
