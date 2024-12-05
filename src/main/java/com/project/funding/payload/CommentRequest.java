package com.project.funding.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 댓글 요청 데이터
 * 클라이언트가 새로운 댓글을 생성할 때 필요한 데이터를 포함
 */
public class CommentRequest {

	@NotNull(message = "프로젝트 ID는 필수입니다.")
	private Long projectId; // 댓글이 달릴 프로젝트 ID

	@NotBlank(message = "댓글 내용은 필수입니다.")
	private String content; // 댓글 내용

	@NotNull(message = "카테고리 정보는 필수입니다.")
	private Long categoryId; // 카테고리 ID

	// 기본 생성자
	public CommentRequest() {}

	// Getter와 Setter
	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
}
