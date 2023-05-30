package com.spi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spi.entity.Sales;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Integer> {

	@Query(value = "SELECT * FROM sales ORDER BY sid DESC LIMIT 3", nativeQuery = true)
	List<Sales> getTopThreeSales();
}