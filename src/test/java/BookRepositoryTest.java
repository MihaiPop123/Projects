import org.example.model.Book;
import org.example.model.Genres;
import org.example.repository.BookRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
        book.setGenre(Genres.THRILLER);
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
//        Book book = new Book();
//        book.setISBN("647921235456");
//        book.setTitle("Jaguar");
//        book.setGenre(Genres.DRAMA);
//        Date dt = new Date(2005, 8, 8);
//        book.setDateOfRelease(dt);
//        book.setPublisher("Penguin");
//        book.setBookAuthors(null);
//        book.setReviews(null);
//        Book book2 = bookRepository.update(book);
//
//        Optional<Book> updatedBook = bookRepository.findByISBN(book.getISBN());
//        assertTrue(updatedBook.isPresent());
//        assertEquals("Jaguar", updatedBook.get().getTitle());
//    }

//    @Test
//    void findById() {
//        Car c1 = carRepository.saveCar(new Car("AUDI", "RS7", Engine.DIESEL, 75.620, null, null));
//
//        Optional<Car> car = carRepository.findById(c1.getId());
//        assertTrue(car.isPresent());
//        assertEquals(c1.getId(), car.get().getId());
//    }
//
//    @Test
//    void findAll() {
//        Car c1 = carRepository.saveCar(new Car("AUDI", "RS7", Engine.DIESEL, 75.620, null, null));
//
//        List<Car> cars = carRepository.findAll();
//        assertNotNull(cars);
//        assertEquals(1, cars.size());
//    }
//
    @AfterAll
    static void afterAll() {

    }

    @AfterEach
    void tearDown() {
        
    }

}
