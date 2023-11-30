package com.kitabkaksha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitabkaksha.entity.Books;
import com.kitabkaksha.entity.Reviews;
import com.kitabkaksha.entity.Users;
import com.kitabkaksha.exception.NotFoundException;
import com.kitabkaksha.repository.ReviewRepository;

@Service
public class ReviewServiceImpl implements ReviewService {
	@Autowired
	private ReviewRepository reviewRepo;
	@Autowired
	private BookService bookService;
	@Autowired
	private UserService userService;

	@Override
	public Reviews addReview(Reviews review, Integer userId, Integer bookId) {
		Books book = bookService.getBookById(bookId);
		Users user = userService.getByUserId(userId);
		review.setBookId(book);
		review.setUserId(user);
		return reviewRepo.save(review);
	}

	@Override
	public Reviews getReviewById(Integer reviewId) {
		Reviews review = reviewRepo.findById(reviewId).orElseThrow(() -> new NotFoundException("Review not found!"));
		return review;
	}

	@Override
	public List<Reviews> getAllReview() {

		return reviewRepo.findAll();
	}

}
