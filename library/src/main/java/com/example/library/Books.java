package com.example.library;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookid;

    @Column(nullable = false)
    private String bookname;

    @Column(nullable = false)
    private Long totalbookquantity;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private Long availablebookquantity;


    @Lob
    @Column( columnDefinition = "BLOB")
    private byte[] bookimage;
    public Books(Long bookid, String bookname, Long totalbookquantity, String author, String type, Long availablebookquantity, byte[] bookimage) {
        this.bookid = bookid;
        this.bookname = bookname;
        this.totalbookquantity = totalbookquantity;
        this.author = author;
        this.type = type;
        this.availablebookquantity = availablebookquantity;
        this.bookimage = bookimage;
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

    public Long getTotalbookquantity() {
        return totalbookquantity;
    }

    public void setTotalbookquantity(Long totalbookquantity) {
        this.totalbookquantity = totalbookquantity;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getAvailablebookquantity() {
        return availablebookquantity;
    }

    public void setAvailablebookquantity(Long availablebookquantity) {
        this.availablebookquantity = availablebookquantity;
    }

    public byte[] getBookimage() {
        return bookimage;
    }

    public void setBookimage(byte[] bookimage) {
        this.bookimage = bookimage;
    }

    public Books() {

    }

}
