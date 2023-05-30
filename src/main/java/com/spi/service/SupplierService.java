package com.spi.service;

import java.util.List;

import com.spi.entity.SupplierEntity;

public interface SupplierService {
	public boolean addSupplier(SupplierEntity supplier);

	public List<SupplierEntity> getAllSuppliers();

	public SupplierEntity getSupplierById(int id);

	public boolean updateSupplier(SupplierEntity entity);

	public boolean deleteSupplier(int id);

}
