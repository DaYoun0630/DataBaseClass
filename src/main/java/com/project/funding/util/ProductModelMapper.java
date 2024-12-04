package com.project.funding.util;

import com.project.funding.model.Projects;
import com.project.funding.payload.ProjectResponse;
//import com.project.funding.payload.ReviewResponse;

public class ProductModelMapper {

	public static ProjectResponse mapProductToProductResponse(Projects product) {

		ProjectResponse productResponse = new ProjectResponse();

//		productResponse.setProductId(product.getId());
		productResponse.setProductName(product.getProductName());
		productResponse.setProductPrice(product.getProductPrice());
		productResponse.setProductExplain(product.getProductExplain());
		productResponse.setStack(product.getStock());
		productResponse.setCategory(product.getCategory());

//		List<ReviewResponse> reviewResponses = product.getReviews().stream().map(review -> {
//			ReviewResponse reviewResponse = new ReviewResponse();
//
//			reviewResponse.setReviewId(review.getId());
//			reviewResponse.setReviewScore(review.getReviewScore());
//			reviewResponse.setReviewContent(review.getReviewContent());
//
//			return reviewResponse;
//		}).collect(Collectors.toList());

//		productResponse.setReviews(reviewResponses);

		return productResponse;
	}

}