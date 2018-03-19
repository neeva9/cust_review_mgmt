package com.example.cust.review.dao;

import com.example.cust.review.dataobjects.FindRatingRequest;
import com.example.cust.review.entity.ProductReview;

/**
 * This interface will enable the service layer to communicate to the data
 * access objects
 *
 */
public interface ProductRatingDAO {

	public String findProductRating(FindRatingRequest findRatingRequest);

	public ProductReview addProductRating(ProductReview productReview);

}
