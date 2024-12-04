package com.project.funding.payload;

public class ProjectRequest {
	private String projectName;

	private int projectPrice;

	private int stock;

	private String category;

	private String projectExplain;

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

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getProjectExplain() {
		return projectExplain;
	}

	public void setProjectExplain(String projectExplain) {
		this.projectExplain = projectExplain;
	}


}
