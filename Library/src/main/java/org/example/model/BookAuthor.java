package org.example.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class BookAuthor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer author_id;

    private String name;
    @Enumerated(EnumType.STRING)
    private Nationalities nationality;

    private Integer yearOfBirth;
    @ManyToMany(mappedBy = "bookAuthors")
    private List<Book> bookList;



    public Integer getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Integer author_id) {
        this.author_id = author_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Nationalities getNationality() {
        return nationality;
    }

    public void setNationality(Nationalities nationality) {
        this.nationality = nationality;
    }

    public Integer getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(Integer yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
