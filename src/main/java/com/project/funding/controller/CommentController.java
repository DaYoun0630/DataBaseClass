package com.project.funding.controller;

import com.project.funding.model.Category;
import com.project.funding.model.Comment;
import com.project.funding.payload.ApiResponse;
import com.project.funding.payload.CommentRequest;
import com.project.funding.security.CurrentUser;
import com.project.funding.security.UserPrincipal;
import com.project.funding.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/comments") // 댓글 API의 기본 경로
public class CommentController {

    @Autowired
    private CommentService commentService;

    // 새로운 댓글 생성
    @PostMapping
    @PreAuthorize("hasRole('USER')") // USER 권한이 있어야 접근 가능
    public ResponseEntity<?> createComment(
            @Valid @RequestBody CommentRequest commentRequest,
            @CurrentUser UserPrincipal currentUser // 현재 로그인한 사용자 정보
    ) {
        // 댓글 생성
        Comment comment = commentService.createComment(commentRequest, currentUser.getUserId());
        return ResponseEntity.ok(new ApiResponse(true, "Comment created successfully."));
    }

    // 특정 프로젝트에 속한 댓글 조회
    @GetMapping("/project/{projectId}")
    public ResponseEntity<List<Comment>> getCommentsByProjectId(@PathVariable Long projectId) {
        List<Comment> comments = commentService.getCommentsByProjectId(projectId);
        return ResponseEntity.ok(comments);
    }

    // 특정 사용자가 작성한 댓글 조회
    @GetMapping("/user/{userId}")
    @PreAuthorize("hasRole('ADMIN') or #userId == principal.id") // ADMIN이거나 본인만 접근 가능
    public ResponseEntity<List<Comment>> getCommentsByUserId(@PathVariable String userId) {
        List<Comment> comments = commentService.getCommentsByUserId(userId);
        return ResponseEntity.ok(comments);
    }

    // 특정 카테고리에 속한 댓글 조회
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Comment>> getCommentsByCategory(@PathVariable Category category) {
        List<Comment> comments = commentService.getCommentsByCategory(category);
        return ResponseEntity.ok(comments);
    }

    // 댓글 삭제
    @DeleteMapping("/{commentId}")
    @PreAuthorize("hasRole('USER')") // USER 권한이 있어야 접근 가능
    public ResponseEntity<?> deleteComment(
            @PathVariable Long commentId,
            @CurrentUser UserPrincipal currentUser
    ) {
        commentService.deleteComment(commentId, currentUser.getUserId());
        return ResponseEntity.ok(new ApiResponse(true, "Comment deleted successfully."));
    }
}
