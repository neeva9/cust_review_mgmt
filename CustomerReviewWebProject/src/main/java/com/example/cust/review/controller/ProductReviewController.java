package com.example.cust.review.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.cust.review.dataobjects.FindRatingRequest;
import com.example.cust.review.dataobjects.FindRatingResponse;
import com.example.cust.review.dataobjects.ProductRatingRequest;
import com.example.cust.review.dataobjects.ProductRatingResponse;
import com.example.cust.review.exception.CommentNotAllowedToAdd;
import com.example.cust.review.exception.RatingNotAllowed;
import com.example.cust.review.service.ProductRatingService;

/**
 * This controller will leverage methods that allow product rating features e.g.
 * find review, add review
 *
 */
@Controller
public class ProductReviewController {

	@Autowired
	private ProductRatingService productRatingService;

	/**
	 * Method to total number of ratings of a product in a defined range
	 * 
	 * @param findRatingRequest
	 * @return
	 */
	@RequestMapping(value = "/product/rating/find", method = RequestMethod.POST)
	public @ResponseBody FindRatingResponse findProductRating(@RequestBody FindRatingRequest findRatingRequest) {
		return productRatingService.findProductRating(findRatingRequest);
	}

	/**
	 * Method to add review for a product
	 * 
	 * @param productRatingRequest
	 * @return
	 * @throws CommentNotAllowedToAdd
	 * @throws RatingNotAllowed
	 */
	@RequestMapping(value = "/product/rating/add", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<ProductRatingResponse> addProductRating(
			@RequestBody ProductRatingRequest productRatingRequest) throws CommentNotAllowedToAdd, RatingNotAllowed {
		ProductRatingResponse productReview = productRatingService.addProductRating(productRatingRequest);
		return new ResponseEntity<ProductRatingResponse>(productReview, HttpStatus.OK);
	}

}