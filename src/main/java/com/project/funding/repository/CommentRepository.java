package com.project.funding.repository;

import com.project.funding.model.Comment;
import com.project.funding.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    // 특정 프로젝트에 속한 댓글 조회
    List<Comment> findByProjectId(Long projectId);

    // 특정 사용자가 작성한 댓글 조회
    List<Comment> findByUserId(String userId);

    // 특정 카테고리에 속한 댓글 조회 (Category 객체 기반)
    List<Comment> findByCategory(Category category);

    // 특정 프로젝트의 특정 사용자가 작성한 댓글 조회
    List<Comment> findByProjectIdAndUserId(Long projectId, String userId);
}
