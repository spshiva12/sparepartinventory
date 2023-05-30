package com.spi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spi.entity.SupplierEntity;
import com.spi.exception.SupplierNotFoundException;
import com.spi.service.SupplierServiceImpl;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
	@Autowired
	private SupplierServiceImpl impl;

	@PostMapping("/addSupplier")
	public ResponseEntity<String> addSupplier(@RequestBody SupplierEntity supplier) {
		String str = "";
		boolean addSupplier = impl.addSupplier(supplier);
		if (addSupplier) {
			str = "Supplier registered.....!!";
		} else {
			str = "Supplier Not registered.....!!";
		}
		return ResponseEntity.ok().body(str);

	}

	@GetMapping("/getAllSuppliers")
	public ResponseEntity<List<SupplierEntity>> getAllSuppliers() {
		List<SupplierEntity> allSuppliers = impl.getAllSuppliers();

		return ResponseEntity.ok().body(allSuppliers);

	}

	@GetMapping("/getSupplierById/{id}")
	public ResponseEntity<SupplierEntity> getSupplierById(@PathVariable int id) throws SupplierNotFoundException {
		SupplierEntity supplierById = impl.getSupplierById(id);

		return ResponseEntity.ok().body(supplierById);

	}

	@PutMapping("/updateSupplier")
	public ResponseEntity<String> updateSupplier(@RequestBody SupplierEntity supplier) {
		boolean updateSupplier = impl.updateSupplier(supplier);

		String msg = "";
		if (updateSupplier) {
			msg = "Supplier details updated....";
		} else {
			msg = "Supplier details not updated....";
		}
		return ResponseEntity.ok().body(msg);

	}

	@DeleteMapping("/deleteSupplier/{id}")
	public ResponseEntity<String> deleteSupplier(@PathVariable int id) {
		boolean deleteSupplier = impl.deleteSupplier(id);
		String msg = "";
		if (deleteSupplier) {
			msg = "Supplier deleted...";
		} else {
			msg = "Supplier not deleted...";
		}
		return ResponseEntity.ok().body(msg);

	}

}
