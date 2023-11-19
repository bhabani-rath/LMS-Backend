package com.example.library;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface IssuedbooksRepository extends JpaRepository<IssuedBooks,Long> {

    @Query("SELECT ib FROM IssuedBooks ib WHERE ib.userid = :userId")
    List<IssuedBooks> findByUserId(Long userId);

    @Query(value = "SELECT * FROM IssuedBooks WHERE due_date < CURRENT_TIMESTAMP", nativeQuery = true)
    List<IssuedBooks> findOverdueBooks(LocalDateTime currentDate);
}
