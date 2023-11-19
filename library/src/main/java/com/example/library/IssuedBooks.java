package com.example.library;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Data
@Entity
@Table
public class IssuedBooks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long userid;

    @Column
    private String username;

    @Column
    private Long bookid;

    @Column
    private String bookname;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime issued_date= LocalDateTime.now();



    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime due_date = LocalDateTime.now().plus(7, ChronoUnit.DAYS);

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getBookid() {
        return bookid;
    }

    public void setBookid(Long bookid) {
        this.bookid = bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public LocalDateTime getIssued_date() {
        return issued_date;
    }

    public void setIssued_date(LocalDateTime issued_date) {
        this.issued_date = issued_date;
    }

    public LocalDateTime getDue_date() {
        return due_date;
    }

    public void setDue_date(LocalDateTime due_date) {
        this.due_date = due_date;
    }

    public IssuedBooks(Long id, Long userid, String username, Long bookid, String bookname, LocalDateTime issued_date, LocalDateTime due_date) {
        this.id = id;
        this.userid = userid;
        this.username = username;
        this.bookid = bookid;
        this.bookname = bookname;
        this.issued_date = issued_date;
        this.due_date = due_date;
    }

    public IssuedBooks() {
    }
}
