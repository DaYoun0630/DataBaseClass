package com.project.funding.service;

import com.project.funding.model.Comment;
import com.project.funding.model.ProjectRegistration;
import com.project.funding.model.User;
import com.project.funding.model.Category;
import com.project.funding.payload.CommentRequest;
import com.project.funding.repository.CommentRepository;
import com.project.funding.repository.ProjectRegistrationRepository;
import com.project.funding.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ProjectRegistrationRepository projectRegistrationRepository;

    @Autowired
    private UserRepository userRepository;

    // 새로운 댓글 생성
    @Transactional
    public Comment createComment(CommentRequest commentRequest, String userId) {
        // 프로젝트 조회
        ProjectRegistration project = projectRegistrationRepository.findById(commentRequest.getProjectId())
                .orElseThrow(() -> new RuntimeException("Project not found with ID: " + commentRequest.getProjectId()));

        // 사용자 조회
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

        // Category 객체 설정
        Category category = project.getCategory(); // 프로젝트에서 카테고리 가져오기

        // 새로운 댓글 생성
        Comment comment = new Comment();
        comment.setProject(project);
        comment.setUser(user);
        comment.setContent(commentRequest.getContent());
        comment.setCategory(category); // 카테고리 설정

        // 댓글 저장
        return commentRepository.save(comment);
    }

    // 특정 프로젝트의 댓글 조회
    @Transactional(readOnly = true)
    public List<Comment> getCommentsByProjectId(Long projectId) {
        return commentRepository.findByProjectId(projectId);
    }

    // 특정 사용자가 작성한 댓글 조회
    @Transactional(readOnly = true)
    public List<Comment> getCommentsByUserId(String userId) {
        return commentRepository.findByUserId(userId);
    }

    // 특정 프로젝트의 특정 사용자가 작성한 댓글 조회
    @Transactional(readOnly = true)
    public List<Comment> getCommentsByProjectAndUser(Long projectId, String userId) {
        return commentRepository.findByProjectIdAndUserId(projectId, userId);
    }

    // 특정 카테고리의 댓글 조회
    @Transactional(readOnly = true)
    public List<Comment> getCommentsByCategory(Category category) {
        return commentRepository.findByCategory(category);
    }

    // 댓글 삭제
    @Transactional
    public void deleteComment(Long commentId, String userId) {
        // 댓글 조회
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("Comment not found with ID: " + commentId));

        // 댓글 작성자와 요청한 사용자가 동일한지 확인
        if (!comment.getUser().getUserId().equals(userId)) {
            throw new RuntimeException("You are not authorized to delete this comment.");
        }

        // 댓글 삭제
        commentRepository.delete(comment);
    }
}
