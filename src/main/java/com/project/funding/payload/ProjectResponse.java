package com.project.funding.payload;

public class ProjectResponse {

	private Long projectId;

	private String projectName;

	private int projectPrice;

	private int stack;

	private String projectExplain;

	private String category;

//	private List<ReviewResponse> reviews;

	public Long getProjectId() {
		return projectId;
	}
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public int getProjectPrice() {
		return projectPrice;
	}
	public void setProjectPrice(int projectPrice) {
		this.projectPrice = projectPrice;
	}
	public int getStack() {
		return stack;
	}
	public void setStack(int stack) {
		this.stack = stack;
	}

	public String getProjectExplain() {
		return projectExplain;
	}
	public void setProjectExplain(String projectExplain) {
		this.projectExplain = projectExplain;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
//	public List<ReviewResponse> getReviews() {
//		return reviews;
//	}
//	public void setReviews(List<ReviewResponse> reviews) {
//		this.reviews = reviews;
//	}
}
