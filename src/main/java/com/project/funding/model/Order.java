package com.project.funding.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.project.funding.model.audit.DateAudit;

@Entity
@Table(name="orders")
public class Order extends DateAudit{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 40)
	private int orderPrice;

	@NotBlank
	@Size(max = 80)
	private String orderAddress;

	@NotBlank
	@Size(max = 40)
	private String recipientName;

	@NotBlank
	@Size(max = 20)
	private String orderState;

	@NotBlank
	@Size(max = 20)
	private boolean refundState;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "project_id", nullable = false)
    private Projects project;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}

	public String getOrderAddress() {
		return orderAddress;
	}

	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}

	public String getRecipientName() {
		return recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	public String getOrderState() {
		return orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	public boolean isRefundState() {
		return refundState;
	}

	public void setRefundState(boolean refundState) {
		this.refundState = refundState;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Projects getProject() {
		return project;
	}

	public void setProject(Projects project) {
		this.project = project;
	}



}
