package com.spi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spi.entity.Inventory;


@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

	@Query(value = "SELECT * FROM inventory ORDER BY quantity_in_Stock DESC LIMIT 5", nativeQuery = true)
	List<Inventory> getTopFiveSpareparts();

	@Query(value = "SELECT * FROM inventory ORDER BY quantity_in_Stock ASC LIMIT 3 ", nativeQuery = true)
	List<Inventory> getLeastThreeSpareparts();
}