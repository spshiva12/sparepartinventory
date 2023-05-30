package com.spi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spi.entity.SupplierEntity;

public interface SupplierRepo extends JpaRepository<SupplierEntity, Integer> {
	public SupplierEntity findByEmail(String email);

}
