package org.example.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Book {
    @Id
    private String ISBN;
    private String title;
    @Enumerated(EnumType.STRING)
    private Genres genre;
    private Date dateOfRelease;

    private String publisher;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "book_author",
            joinColumns = @JoinColumn(name = "ISBN"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<BookAuthor> bookAuthors;
    @OneToMany(mappedBy = "book")
    private List<Review> reviews;

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Genres getGenre() {
        return genre;
    }

    public void setGenre(Genres genre) {
        this.genre = genre;
    }

    public Date getDateOfRelease() {
        return dateOfRelease;
    }

    public void setDateOfRelease(Date dateOfRelease) {
        this.dateOfRelease = dateOfRelease;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public List<BookAuthor> getBookAuthors() {
        return bookAuthors;
    }

    public void setBookAuthors(List<BookAuthor> bookAuthors) {
        this.bookAuthors = bookAuthors;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
