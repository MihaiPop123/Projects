package org.example.model;

import jakarta.persistence.*;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_review;
    private Double average_score;
    private String text;
    @ManyToOne
    @JoinColumn
    private Book book;

    public Integer getId_review() {
        return id_review;
    }

    public void setId_review(Integer id_review) {
        this.id_review = id_review;
    }

    public Double getAverage_score() {
        return average_score;
    }

    public void setAverage_score(Double average_score) {
        this.average_score = average_score;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
