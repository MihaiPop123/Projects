package org.example.service;

import org.example.exceptions.InvalidBookException;
import org.example.model.Review;
import org.example.repository.ReviewRepository;

public class ReviewService {

    private ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public void insertReview(Review review){
        if (review.getAverage_score() == null || review.getText() == null) {
            throw new InvalidBookException("Invalid review!");
        }
        reviewRepository.save(review);
    }

    public void deleteReview(Review review){
        if (review.getAverage_score() == null || review.getText() == null) {
            throw new InvalidBookException("Invalid review!");
        }
        reviewRepository.delete(review);
    }

    public void updateReview(Review review){
        if (review.getAverage_score() == null || review.getText() == null) {
            throw new InvalidBookException("Invalid review!");
        }
        reviewRepository.update(review);
    }

    public String listAllReviews() {
        return reviewRepository.findAll().toString();
    }
}

