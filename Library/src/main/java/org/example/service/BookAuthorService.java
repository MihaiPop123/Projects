package org.example.service;

import org.example.exceptions.InvalidBookException;
import org.example.model.BookAuthor;
import org.example.repository.BookAuthorRepository;

public class BookAuthorService {

    private BookAuthorRepository bookAuthorRepository;

    public BookAuthorService(BookAuthorRepository bookAuthorRepository) {
        this.bookAuthorRepository = bookAuthorRepository;
    }

    public void insertBookAuthor(BookAuthor bookAuthor){
        if (bookAuthor.getName() == null || bookAuthor.getNationality() == null) {
            throw new InvalidBookException("Invalid author!");
        }
        bookAuthorRepository.save(bookAuthor);
    }

    public void updateBookAuthor(BookAuthor bookAuthor){
        if (bookAuthor.getName() == null || bookAuthor.getNationality() == null) {
            throw new InvalidBookException("Invalid author!");
        }
        bookAuthorRepository.update(bookAuthor);
    }

    public void deleteAuthorBook(BookAuthor bookAuthor){
        if (bookAuthor.getName() == null || bookAuthor.getNationality() == null) {
            throw new InvalidBookException("Invalid author!");
        }
        bookAuthorRepository.update(bookAuthor);
    }

    public String listAllBookAuthors() {
        return bookAuthorRepository.findAll().toString();
    }
}
