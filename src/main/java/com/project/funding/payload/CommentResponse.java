package com.project.funding.payload;

import java.time.LocalDateTime;

/**
 * 댓글 응답 데이터
 * 서버가 클라이언트에게 반환하는 댓글 데이터를 포함
 */
public class CommentResponse {

	private Long commentId; // 댓글 ID
	private String content; // 댓글 내용
	private LocalDateTime createdAt; // 댓글 생성 날짜
	private String userId; // 댓글 작성자 ID
	private String userName; // 댓글 작성자 이름
	private Long projectId; // 댓글이 달린 프로젝트 ID
	private Long categoryId; // 카테고리 ID

	// 기본 생성자
	public CommentResponse() {}

	// Getter와 Setter
	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
}
