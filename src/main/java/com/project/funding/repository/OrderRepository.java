package com.project.funding.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.funding.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
	Optional<Order> findById(Long orderId);

	List<Order> findByIdIn(List<Long> orderIds);

	@Query("SELECT DISTINCT o.project.id FROM Order o WHERE o.user.id = :userId")
	List<Long> findOrderedProjectIdByUserId(@Param("userId") Long userId);

	@Query("SELECT o FROM Order o WHERE o.user.id = :userId")
	Page<Order> findOrderByUserId(@Param("userId") Long userId, Pageable pageable);
}
