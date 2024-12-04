package com.project.funding.controller;

import java.net.URI;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.project.funding.model.Projects;
import com.project.funding.payload.ApiResponse;
import com.project.funding.payload.PagedResponse;
import com.project.funding.payload.ProjectRequest;
import com.project.funding.payload.ProjectResponse;
import com.project.funding.repository.ProjectRepository;
import com.project.funding.security.CurrentUser;
import com.project.funding.security.UserPrincipal;
import com.project.funding.service.ProjectService;
import com.project.funding.util.AppConstants;

@RestController // REST API 요청을 처리하는 컨트롤러 클래스임을 선언
@RequestMapping("/api/project") // "/api/project로 시작하는 URL을 처리하는 컨트롤러
public class ProjectController {

	@Autowired // 필요한 의존성을 자동으로 주입
	private ProjectRepository projectRepository; // 데이터베이스와 상호작용하는 Repository 객체

	@Autowired
	private ProjectService projectService; // 비즈니스 로직을 처리하는 Service 객체

	private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);
	// 로깅을 위한 Logger 객체. 로그를 기록할 때 사용

	// 모든 상품을 조회하는 API
	@GetMapping("/explore") // "/explore" 경로로 GET 요청을 처리
	@PreAuthorize("hasRole('USER')") // "USER" 역할을 가진 사용자만 접근 가능
	public PagedResponse<ProjectResponse> getAllProjects(
			@CurrentUser UserPrincipal currentUser, // 현재 로그인한 사용자 정보
			@RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page, // 페이지 번호 (기본값: 0)
			@RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size // 페이지당 항목 수 (기본값: AppConstants에 정의된 값)
	) {
		// ProjectService를 호출하여 상품 목록 데이터를 가져옴
		return projectService.getAllProjects(currentUser, page, size);
	}

	// 새로운 상품을 등록하는 API
	@PostMapping("/register") // "/register" 경로로 POST 요청을 처리
	@PreAuthorize("hasRole('ADMIN')") // "ADMIN" 역할을 가진 사용자만 접근 가능
	public ResponseEntity<?> registerProject(
			@Valid @RequestBody ProjectRequest projectRequest // 상품 등록에 필요한 데이터를 요청 본문에서 받음
	) {
		// ProjectService를 호출하여 상품 등록 처리
		Projects project = projectService.registerProject(projectRequest);

		// 생성된 상품의 ID를 포함한 URI 생성
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest() // 현재 요청 경로를 기반으로 URI 생성
				.path("/{jectId}") // 생성된 상품 ID를 URI 경로에 추가
				.buildAndExpand(project.getId()) // {projectId}를 생성된 상품 ID로 치환
				.toUri();

		// HTTP 상태 코드 201(Created)와 함께 응답 반환
		return ResponseEntity.created(location)
				.body(new ApiResponse(true, "Project Registered Successfully")); // 성공 메시지를 담아 응답
	}
}
