package com.kitabkaksha.service;

import java.util.List;

import com.kitabkaksha.entity.Reviews;

public interface ReviewService {
  public Reviews addReview(Reviews review, Integer userId, Integer bookId);
  public Reviews getReviewById(Integer reviewId);
  public List<Reviews> getAllReview();
}
