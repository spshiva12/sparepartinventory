package com.spi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spi.entity.SupplierEntity;
import com.spi.exception.SupplierAlreadyExistsException;
import com.spi.exception.SupplierNotFoundException;
import com.spi.repo.SupplierRepo;

@Service
public class SupplierServiceImpl implements SupplierService {
	@Autowired
	private SupplierRepo supplierRepo;

	@Override
	public boolean addSupplier(SupplierEntity supplier) {
		SupplierEntity isExistingSupplier = supplierRepo.findByEmail(supplier.getEmail());

		boolean flag = false;
		if (isExistingSupplier == null) {
			supplierRepo.save(supplier);
			flag = true;
		} else {
			throw new SupplierAlreadyExistsException("Supplier Already exists by this name....");
		}

		return flag;
	}

	@Override
	public List<SupplierEntity> getAllSuppliers() {
		List<SupplierEntity> allSuppliers = supplierRepo.findAll();
		return allSuppliers;
	}

	@Override
	public SupplierEntity getSupplierById(int id) {
//		Optional<SupplierEntity> findById = supplierRepo.findById(id);
//		SupplierEntity supplierEntity = findById.get();

		return supplierRepo.findById(id)
				.orElseThrow(() -> new SupplierNotFoundException("NO SUPPLIER PRESENT WITH ID = " + id));

	}

	@Override
	public boolean updateSupplier(SupplierEntity entity) {
		SupplierEntity findById = supplierRepo.findById(entity.getId())
				.orElseThrow(() -> new SupplierNotFoundException("NO SUPPLIER PRESENT WITH ID = " + entity.getId()));

		// SupplierEntity supplierEntity = findById.get();
		boolean b = false;
		if (findById != null) {
			SupplierEntity isUpdated = supplierRepo.save(entity);
			if (isUpdated != null) {
				b = true;
			}
		}
		return b;
	}

	@Override
	public boolean deleteSupplier(int id) {
//		Optional<SupplierEntity> findById = supplierRepo.findById(id);
		SupplierEntity supplierEntity = supplierRepo.findById(id)
				.orElseThrow(() -> new SupplierNotFoundException("NO SUPPLIER PRESENT WITH ID = " + id));

		boolean isdeleted = false;
		if (supplierEntity != null) {
			supplierRepo.deleteById(id);
			isdeleted = true;
		}
		return isdeleted;
	}

}
