package com.project.funding.service;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.project.funding.exception.BadRequestException;
import com.project.funding.model.Projects;
import com.project.funding.payload.PagedResponse;
import com.project.funding.payload.ProjectRequest;
import com.project.funding.payload.ProjectResponse;
import com.project.funding.repository.ProjectRepository;
import com.project.funding.repository.UserRepository;
import com.project.funding.security.UserPrincipal;
import com.project.funding.util.AppConstants;
import com.project.funding.util.ProductModelMapper;

@Service // 이 클래스가 서비스 계층 역할을 수행하며, 비즈니스 로직을 처리함을 선언
public class ProjectService {

	@Autowired // 필요한 의존성을 자동으로 주입
	private ProjectRepository productRepository; // 상품 데이터를 처리하는 레포지토리

	@Autowired
	private UserRepository userRepository; // 사용자 데이터를 처리하는 레포지토리

	private static final Logger logger = LoggerFactory.getLogger(ProjectService.class);
	// 로깅을 위한 Logger 객체. 서버 이벤트를 기록할 때 사용

	// 새로운 상품을 등록하는 메서드
	public Projects registerProduct(ProjectRequest productRequest) {
		Projects product = new Projects(); // 새로운 상품 객체 생성

		// 상품 객체의 속성 설정
		product.setProductName(productRequest.getProductName()); // 상품 이름 설정
		product.setProductExplain(productRequest.getProductExplain()); // 상품 설명 설정
		product.setProductPrice(productRequest.getProductPrice()); // 상품 가격 설정
		product.setStock(productRequest.getStock()); // 상품 재고 설정
		product.setCategory(productRequest.getCategory()); // 상품 카테고리 설정

		// 데이터베이스에 상품 저장 후 반환
		return productRepository.save(product);
	}

	// 모든 상품 목록을 페이징 처리하여 조회하는 메서드
	public PagedResponse<ProjectResponse> getAllProducts(UserPrincipal currentUser, int page, int size) {
		validatePageNumberAndSize(page, size); // 페이지 번호와 크기 검증

		// 페이징 및 정렬 설정 (최신 상품 순으로 정렬)
		Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createdAt");

		// 모든 상품 데이터 조회
		Page<Projects> products = productRepository.findAll(pageable);

		// 조회된 데이터가 없는 경우 빈 응답 반환
		if(products.getNumberOfElements() == 0) {
			return new PagedResponse<>(Collections.emptyList(), products.getNumber(),
					products.getSize(), products.getTotalElements(), products.getTotalPages(), products.isLast());
		}

		// 상품 데이터를 ProductResponse 객체로 변환
		List<ProjectResponse> productResponses = products.map(product -> {
			return ProductModelMapper.mapProductToProductResponse(product);
		}).getContent();

		// 페이징된 응답 반환
		return new PagedResponse<>(productResponses, products.getNumber(),
				products.getSize(), products.getTotalElements(), products.getTotalPages(), products.isLast());
	}

	// 페이지 번호와 크기를 검증하는 유틸리티 메서드
	private void validatePageNumberAndSize(int page, int size) {
		if(page < 0) { // 페이지 번호가 음수일 경우 예외 발생
			throw new BadRequestException("Page number cannot be less than zero.");
		}

		if(size > AppConstants.MAX_PAGE_SIZE) { // 페이지 크기가 최대 크기를 초과할 경우 예외 발생
			throw new BadRequestException("Page size must not be greater than " + AppConstants.MAX_PAGE_SIZE);
		}
	}
}
