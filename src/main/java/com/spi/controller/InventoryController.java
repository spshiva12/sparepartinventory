package com.spi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spi.entity.Inventory;
import com.spi.exception.SparepartsNotfoundException;
import com.spi.exception.SparepartsRecordNotfoundException;
import com.spi.service.Inventoryimplementation;

@RestController
@RequestMapping("/inventory")
@CrossOrigin(origins = "http://localhost:3000/")
public class InventoryController {

	@Autowired
	private Inventoryimplementation impl;

	@PostMapping("/addSpareparts")
	public ResponseEntity<String> addSpareparts(@RequestBody Inventory inventory) {
		boolean createSpareparts = impl.createSpareparts(inventory);
		String message;
		if (createSpareparts) {
			message = "added successfully";
		} else {
			message = "not added successfully";
		}
		return ResponseEntity.ok(message);
	}

	@GetMapping("/viewSpareparts")
	public ResponseEntity<List<Inventory>> getSparepartsparts() throws SparepartsNotfoundException {

		List<Inventory> spareparts = impl.getSpareparts();
		if (spareparts != null) {
			return ResponseEntity.ok().body(spareparts);

		} else
			throw new SparepartsNotfoundException(" spare parts are not founded in the database");

	}

	@GetMapping("/viewSparepart/{partNumber}")
	public ResponseEntity<Inventory> getSparepartsById(@PathVariable("partNumber") Long partNumber)
			throws SparepartsNotfoundException {
		Inventory byId = impl.getById(partNumber);

		return ResponseEntity.ok().body(byId);

	}

	@PutMapping("/updateSpareparts")
	public ResponseEntity<String> updateSpareparts(@RequestBody Inventory inventory) {

		boolean updateSpareParts = impl.updateSpareParts(inventory);
		String msg;
		if (updateSpareParts) {
			msg = "updated";
		} else {
			msg = "not updated";
		}
		return ResponseEntity.ok().body(msg);

	}

	@DeleteMapping("/deleteSpareparts/{partNumber}")
	public ResponseEntity<String> deleteSpareparts(@PathVariable("partNumber") long partNumber)
			throws SparepartsNotfoundException {
		boolean deleteSpareparts = impl.deleteSpareparts(partNumber);

		if (deleteSpareparts)
			return ResponseEntity.ok().body("Deleted successfully");
		else
			throw new SparepartsNotfoundException("");
	}

	@GetMapping("/getTop5")
	public ResponseEntity<List<Inventory>> getTop5Spareparts() throws SparepartsRecordNotfoundException {
		List<Inventory> top5 = impl.getTop5();
		if (top5 != null)
			return ResponseEntity.ok().body(top5);
		else
			throw new SparepartsRecordNotfoundException("Spareparts are not founded:");

	}

	@GetMapping("getLeast3Spareparts")
	public ResponseEntity<List<Inventory>> getLeast3Spareparts() throws SparepartsRecordNotfoundException {

		List<Inventory> lastThree = impl.getLastThree();

		if (lastThree != null)
			return ResponseEntity.ok().body(lastThree);
		else
			throw new SparepartsRecordNotfoundException("Spareparts are not founded:");

	}
}
