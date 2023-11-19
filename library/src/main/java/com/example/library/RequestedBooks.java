package com.example.library;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class RequestedBooks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long req_id;

    @Column
    private Long userid;


    @Column
    private String username;

    @Column
    private Long bookid;

    @Column
    private String bookname;
    public RequestedBooks() {
    }

    public Long getReq_id() {
        return req_id;
    }

    public void setReq_id(Long req_id) {
        this.req_id = req_id;
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

    public RequestedBooks(Long req_id, Long userid, String username, Long bookid, String bookname) {
        this.req_id = req_id;
        this.userid = userid;
        this.username = username;
        this.bookid = bookid;
        this.bookname = bookname;
    }
}
