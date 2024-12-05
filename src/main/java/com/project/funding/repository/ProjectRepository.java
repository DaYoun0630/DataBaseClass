package com.project.funding.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.funding.model.Projects;

import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Projects, Long> {

	Optional<Projects> findById(Long projectId);

	boolean existsByName(String name); // 상품 이름 중복 확인

}
