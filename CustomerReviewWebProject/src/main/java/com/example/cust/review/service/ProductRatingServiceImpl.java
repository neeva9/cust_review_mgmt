package com.example.cust.review.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import com.example.cust.review.dao.ProductRatingDAO;
import com.example.cust.review.dataobjects.FindRatingRequest;
import com.example.cust.review.dataobjects.FindRatingResponse;
import com.example.cust.review.dataobjects.ProductRatingRequest;
import com.example.cust.review.dataobjects.ProductRatingResponse;
import com.example.cust.review.entity.ProductReview;
import com.example.cust.review.exception.CommentNotAllowedToAdd;
import com.example.cust.review.exception.RatingNotAllowed;

/**
 * This service will provide methods for product rating
 *
 */
@PropertySource("classpath:config.properties")
public class ProductRatingServiceImpl implements ProductRatingService {

	@Autowired
	private FindRatingResponse findRatingResponse;

	@Autowired
	private ProductRatingDAO productRatingDAO;

	@Value("${config.curseWordList}")
	private String curseWordString;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.example.cust.review.service.ProductRatingService#findProductRating(
	 * com.example.cust.review.dataobjects.FindRatingRequest)
	 */
	public FindRatingResponse findProductRating(FindRatingRequest findRatingRequest) {
		String rating = productRatingDAO.findProductRating(findRatingRequest);
		return findRatingResponse.setTotalRating(rating);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.example.cust.review.service.ProductRatingService#addProductRating(com
	 * .example.cust.review.dataobjects.ProductRatingRequest)
	 */
	/* (non-Javadoc)
	 * @see com.example.cust.review.service.ProductRatingService#addProductRating(com.example.cust.review.dataobjects.ProductRatingRequest)
	 */
	public ProductRatingResponse addProductRating(ProductRatingRequest productRatingRequest)
			throws CommentNotAllowedToAdd, RatingNotAllowed {
		List<String> curseWordsList = Arrays.asList(curseWordString.split(","));
		for (String curseWord : curseWordsList) {
			if (productRatingRequest.getComment().contains(curseWord)) {
				throw new CommentNotAllowedToAdd();
			} 
		}
		if (productRatingRequest.getRating() <= 0) {
			throw new RatingNotAllowed();
		}
		ProductReview productReview = convertRequestToEntity(productRatingRequest);
		ProductReview addProductRating = productRatingDAO.addProductRating(productReview);

		return convertEntityToResponse(addProductRating);
	}

	private ProductReview convertRequestToEntity(ProductRatingRequest productRatingRequest) {
		ProductReview productReview = new ProductReview();
		productReview.setId(productRatingRequest.getProductId());
		productReview.setName(productRatingRequest.getComment());
		productReview.setRating(productRatingRequest.getRating());
		return productReview;
	}

	private ProductRatingResponse convertEntityToResponse(ProductReview productReview) {
		ProductRatingResponse ratingResponse = new ProductRatingResponse();
		ratingResponse.setProductId((int) productReview.getId());
		ratingResponse.setName(productReview.getName());
		ratingResponse.setDesc(productReview.getDesc());
		ratingResponse.setRating(productReview.getRating());
		return ratingResponse;
	}

}
