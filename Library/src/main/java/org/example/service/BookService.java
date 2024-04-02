package org.example.service;

import org.example.exceptions.InvalidBookException;
import org.example.model.Book;
import org.example.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void insertBook(Book book){
        if (book.getISBN() == null || book.getTitle() == null) {
            throw new InvalidBookException("Invalid book!");
        }
        bookRepository.save(book);
    }

    public void updateBook(Book book){
        if (book.getISBN() == null || book.getTitle() == null) {
            throw new InvalidBookException("Invalid book!");
        }
        bookRepository.update(book);
    }

    public void deleteBook(Book book){
        if (book.getISBN() == null || book.getTitle() == null) {
            throw new InvalidBookException("Invalid book!");
        }
        bookRepository.delete(book);
    }

    public String listAllBooks() {
        return bookRepository.findAll().toString();
    }
}
