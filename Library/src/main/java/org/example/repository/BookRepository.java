package org.example.repository;

import org.example.model.Book;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class BookRepository {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactoryInstance();
    public Book save(Book book){
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.save(book);
            transaction.commit();
            session.close();
        return book;
    }

    public void delete(Book book){
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.remove(book);
            transaction.commit();
            session.close();
    }

    public Book update(Book book){
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.update(book);
            transaction.commit();
            session.close();

            return book;
    }

    public List<Book> findAll(){
        Session session = sessionFactory.openSession();
        Query<Book> query = session.createQuery("select b from Book b");
        return query.list();
    }

    public Optional<Book> findByISBN(String ISBN){
        Session session = sessionFactory.openSession();
        Query<Book> query = session.createQuery("select b from Book b where b.ISBN = :parameter");
        query.setParameter("parameter", ISBN);
        Optional<Book> optionalBook = query.uniqueResultOptional();
        session.close();
        return optionalBook;
    }
}
