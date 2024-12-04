package com.project.funding.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.project.funding.model.audit.DateAudit;

@Entity
@Table(name="projects")
public class Projects extends DateAudit{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 40)
	private String projectName;

	@NotBlank
	@Size(max = 40)
	private int projectPrice;

	@NotBlank
	@Size(max = 40)
	private int stock;

	@NotBlank
	@Size(max = 20)
	private String category;

	@NotBlank
	@Size(max = 40)
	private String projectExplain;

//	@OneToMany(mappedBy = "project")
//	private List<Review> reviews;

	private String name;

	public Projects() {}


//	public Long getId() {
//		return id;
//	}

	public void setId(Long id) {
		this.id = id;
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

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}


//	public List<Review> getReviews() {
//		return reviews;
//	}
//
//
//	public void setReviews(List<Review> reviews) {
//		this.reviews = reviews;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getId() {
        return null;
    }
}
