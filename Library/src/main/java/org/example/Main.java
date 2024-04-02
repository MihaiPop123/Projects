package org.example;


import org.example.model.*;
import org.example.repository.BookAuthorRepository;
import org.example.repository.BookRepository;
import org.example.repository.ReviewRepository;
import org.example.service.BookAuthorService;
import org.example.service.BookService;
import org.example.service.ReviewService;

import java.sql.Date;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    private static BookRepository bookRepository = new BookRepository();
    private static BookAuthorRepository bookAuthorRepository = new BookAuthorRepository();
    private static ReviewRepository reviewRepository = new ReviewRepository();

    private static BookService bookService = new BookService(bookRepository);
    private static BookAuthorService bookAuthorService = new BookAuthorService(bookAuthorRepository);
    private static ReviewService reviewService = new ReviewService(reviewRepository);


    public static void main(String[] args) {
//        bookService.insertBook(createBook());
//        bookAuthorService.insertBookAuthor(createBookAuthor());
//        reviewService.insertReview(createReview());
    }

    public static Book createBook() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is the book's ISBN: ");
        String bookISBN = scanner.nextLine();

        System.out.println("What is the book's title: ");
        String bookTitle = scanner.nextLine();

        System.out.println("What is the books genre: ");
        String bookGenre = scanner.nextLine();

        System.out.println("What is the books release date: ");
        String releaseDate = scanner.nextLine();

        System.out.println("What is the books publisher: ");
        String publisher = scanner.nextLine();

        Book book = new Book();
        book.setISBN(bookISBN);
        book.setTitle(bookTitle);
        book.setGenre(Genres.valueOf(bookGenre));
        book.setDateOfRelease(Date.valueOf(releaseDate));
        book.setPublisher(publisher);

        return book;
    }

    public static BookAuthor createBookAuthor() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is the authors name: ");
        String authorsName = scanner.nextLine();

        System.out.println("What is the authors nationality: ");
        String authorsNationality = scanner.nextLine();

        System.out.println("What is the authors year of birth: ");
        String authorsYearOfBirth = scanner.nextLine();

        BookAuthor bookAuthor = new BookAuthor();
        bookAuthor.setName(authorsName);
        bookAuthor.setNationality(Nationalities.valueOf(authorsNationality));
        bookAuthor.setYearOfBirth(Integer.valueOf(authorsYearOfBirth));

        return bookAuthor;
    }

    public static Review createReview(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is the reviews score: ");
        String reviewScore = scanner.nextLine();

        System.out.println("What is the reviews text: ");
        String reviewText = scanner.nextLine();

        System.out.println("Enter the ISBN of the book that was reviewed: ");
        Integer bookISBN = scanner.nextInt();

        Book book = new Book();
        Optional<Book> optionalBook = bookRepository.findByISBN(String.valueOf(bookISBN));
        if(optionalBook.isPresent()){
            book = optionalBook.get();
        }

        Review review = new Review();
        review.setAverage_score(Double.valueOf(reviewScore));
        review.setText(reviewText);
        review.setBook(book);

        return review;
    }


}