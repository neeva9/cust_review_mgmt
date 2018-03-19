package com.example.cust.review.service;

import com.example.cust.review.dataobjects.FindRatingRequest;
import com.example.cust.review.dataobjects.FindRatingResponse;
import com.example.cust.review.dataobjects.ProductRatingRequest;
import com.example.cust.review.dataobjects.ProductRatingResponse;
import com.example.cust.review.exception.CommentNotAllowedToAdd;
import com.example.cust.review.exception.RatingNotAllowed;

/**
 * This service interface will support methods for product rating feature like
 * find rating, add customer rating etc.
 *
 */
public interface ProductRatingService {

	public FindRatingResponse findProductRating(FindRatingRequest findRatingRequest);

	public ProductRatingResponse addProductRating(ProductRatingRequest productRatingRequest)
			throws CommentNotAllowedToAdd, RatingNotAllowed;

}
