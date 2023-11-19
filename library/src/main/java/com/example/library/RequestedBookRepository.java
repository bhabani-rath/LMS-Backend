package com.example.library;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestedBookRepository extends JpaRepository<RequestedBooks,Long> {
}
