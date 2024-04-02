package org.example.repository;

import org.example.model.BookAuthor;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class BookAuthorRepository {
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactoryInstance();
    public void save(BookAuthor bookAuthor){
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.save(bookAuthor);
            transaction.commit();
            session.close();
    }

    public void delete(BookAuthor bookAuthor){
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.delete(bookAuthor);
            transaction.commit();
            session.close();
    }

    public void update(BookAuthor bookAuthor){
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.update(bookAuthor);
            transaction.commit();
            session.close();
    }

    public List<BookAuthor> findAll(){
        Session session = sessionFactory.openSession();
        Query<BookAuthor> query = session.createQuery("select b from BookAuthor b");
        return query.list();
    }

    public Optional<BookAuthor> findById(Integer author_id) {
        Session session = sessionFactory.openSession();
        Query<BookAuthor> query = session.createQuery("select b from BookAuthor b where b.author_id = :parameter");
        query.setParameter("parameter", author_id);
        Optional<BookAuthor> optionalBookAuthor = query.uniqueResultOptional();
        session.close();
        return optionalBookAuthor;
    }

}
