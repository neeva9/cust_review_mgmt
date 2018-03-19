package com.example.cust.review.dao;

import com.example.cust.review.dataobjects.FindRatingRequest;
import com.example.cust.review.entity.ProductReview;

/**
 * This implementation has commented code for accessing database instead returns
 * hard-coded values
 *
 */
public class ProductRatingDAOImpl implements ProductRatingDAO {

	// @PersistenceContext
	// public EntityManager entityManager;

	public String findProductRating(FindRatingRequest findRatingRequest) {

		// String sql = "select count(productReview) from ProductReview
		// productReview where productReview.rating>="
		// + findRatingRequest.getMinRating() + " and productReview.rating<=" +
		// findRatingRequest.getMaxRating()
		// + "and productReview.id = " + findRatingRequest.getProductId();
		// try {
		// return (String) entityManager.createQuery(sql).getSingleResult();
		// } catch (Exception e) {
		// System.err.println("Query could not be executed.");
		// }
		return "50";
	}

	public ProductReview addProductRating(ProductReview productReview) {
		// entityManager.persist(productReview);
		return productReview;

	}

}
