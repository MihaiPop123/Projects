import org.example.model.Book;
import org.example.model.Genres;
import org.example.repository.BookRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.example.model.Genres.THRILLER;
import static org.junit.jupiter.api.Assertions.*;

public class BookRepositoryTest {

    private static BookRepository bookRepository;

    @BeforeAll
    static void beforeAll() {
        bookRepository = new BookRepository();
    }

    @Test
    void saveBook() {
        Book book = new Book();

        book.setISBN("58447");
        book.setTitle("Maleficent");
        book.setGenre(Genres.FICTION);
        Date dt = new Date(1784, 12, 8);
        book.setDateOfRelease(dt);
        book.setPublisher("Penguin");
        book.setBookAuthors(null);
        book.setReviews(null);

        bookRepository.save(book);
        assertNotNull(book.getISBN());
    }

    @Test
    void removeBook() {
        Book book = new Book();
        book.setISBN("65487");
        book.setTitle("Baracuda");
        book.setGenre(THRILLER);
        Date dt = new Date(2021, 12, 7);
        book.setDateOfRelease(dt);
        book.setPublisher("Russian Tiger");
        book.setBookAuthors(null);
        book.setReviews(null);

//        bookRepository.save(book);
        assertNotNull(book.getISBN());

        bookRepository.delete(book);
        Optional<Book> updatedBook = bookRepository.findByISBN(book.getISBN());
        assertFalse(updatedBook.isPresent());
    }

//    @Test
//    void updateBook() {
////        @Test
////        void updateCar() {
////            Car c1 = new Car("BMW", "M6", Engine.GASOLINE, 113.290, null, null);
////
////            c1.setTravelledDistance(114.098);
////            Car car = carRepository.updateCar(c1);
////
////            Optional<Car> updatedCar = carRepository.findById(car.getId());
////            assertTrue(updatedCar.isPresent());
////            assertEquals(114.098, updatedCar.get().getTravelledDistance());
////        }
//        Book book = new Book();
//        book.setISBN("647921235456");
//        book.setTitle("Jaguar");
//        book.setGenre(Genres.DRAMA);
//        Date dt = new Date(2005, 8, 8);
//        book.setDateOfRelease(dt);
//        book.setPublisher("Penguin");
//        book.setBookAuthors(null);
//        book.setReviews(null);
//
//        book.setGenre(Genres.FICTION);
//        Book book2 = bookRepository.update(book);
//
//        Optional<Book> updatedBook = bookRepository.findByISBN(book2.getISBN());
//        assertTrue(updatedBook.isPresent());
//        assertEquals(Genres.FICTION, updatedBook.get().getGenre());
//    }

    @Test
    void findByISBN() {

//        Book book = new Book();
//        book.setISBN("65487");
//        book.setTitle("Baracuda");
//        book.setGenre(Genres.THRILLER);
//        Date dt = new Date(2021, 12, 7);
//        book.setDateOfRelease(dt);
//        book.setPublisher("Russian Tiger");
//        book.setBookAuthors(null);
//        book.setReviews(null);
//
////        bookRepository.save(book);
//        assertNotNull(book.getISBN());
//
//        bookRepository.delete(book);
//        Optional<Book> updatedBook = bookRepository.findByISBN(book.getISBN());
//        assertFalse(updatedBook.isPresent());

        Book b1 = (new Book());
        b1.setISBN("32165655616");
        b1.setTitle("Pizza Cook Book");
        b1.setGenre(THRILLER);
        Date dt = new Date(2005, 8, 8);
        b1.setDateOfRelease(dt);
        b1.setPublisher("Great Italy");
        b1.setBookAuthors(null);
        b1.setReviews(null);

        bookRepository.save(b1);

        Optional<Book> book = bookRepository.findByISBN(b1.getISBN());
        assertTrue(book.isPresent());
        assertEquals(b1.getISBN(), book.get().getISBN());
    }

    @Test
    void findAll() {

        Book b1 = (new Book());
        b1.setISBN("32165616");
        b1.setTitle("Pizza Cook Book");
        b1.setGenre(Genres.THRILLER);
        Date dt = new Date(2005, 8, 8);
        b1.setDateOfRelease(dt);
        b1.setPublisher("Great Italy");
        b1.setBookAuthors(null);
        b1.setReviews(null);

//        bookRepository.save(b1);

        List<Book> books = bookRepository.findAll();
        assertNotNull(books);
        assertEquals(1, books.size());
    }

    @AfterAll
    static void afterAll() {

    }

    @AfterEach
    void tearDown() {

    }

}
