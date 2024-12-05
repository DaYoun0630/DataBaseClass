package com.project.funding.util;

import com.project.funding.model.Projects;
import com.project.funding.payload.ProjectResponse;
//import com.project.funding.payload.ReviewResponse;

public class ProjectModelMapper {

	public static ProjectResponse mapProjectToProjectResponse(Projects project) {

		ProjectResponse projectResponse = new ProjectResponse();

//		projectResponse.setProjectId(project.getId());
		projectResponse.setProjectName(project.getProjectName());
		projectResponse.setProjectPrice(project.getProjectPrice());
		projectResponse.setProjectExplain(project.getProjectExplain());
		projectResponse.setStack(project.getStock());
		projectResponse.setCategory(project.getCategory());

//		List<ReviewResponse> reviewResponses = project.getReviews().stream().map(review -> {
//			ReviewResponse reviewResponse = new ReviewResponse();
//
//			reviewResponse.setReviewId(review.getId());
//			reviewResponse.setReviewScore(review.getReviewScore());
//			reviewResponse.setReviewContent(review.getReviewContent());
//
//			return reviewResponse;
//		}).collect(Collectors.toList());

//		projectResponse.setReviews(reviewResponses);

		return projectResponse;
	}

}