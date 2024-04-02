package org.example.repository;

import org.example.model.Review;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class ReviewRepository {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactoryInstance();
    public void save(Review review){
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.save(review);
            transaction.commit();
            session.close();
    }

    public void delete(Review review){
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.delete(review);
            transaction.commit();
            session.close();
    }

    public void update(Review review){
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.update(review);
            transaction.commit();
            session.close();
    }

    public List<Review> findAll(){
        Session session = sessionFactory.openSession();
        Query<Review> query = session.createQuery("select r from Review r");
        return query.list();
    }

    public Review findById(Integer id_review) {
        Session session = sessionFactory.openSession();
        Query<Review> query = session.createQuery("select r from Review r where r.id_review = :parameter");
        query.setParameter("parameter", id_review);
        Optional<Review> optionalReview = query.uniqueResultOptional();
        session.close();
        Review review = new Review();
        if(optionalReview.isPresent()) {
            review = optionalReview.get();
        }

        return review;
    }
}
